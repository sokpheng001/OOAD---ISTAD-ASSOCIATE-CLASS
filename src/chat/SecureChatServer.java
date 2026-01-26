package chat;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class SecureChatServer {

    private static final int PORT = 8888;
    private static final String SECRET_KEY = "MySecretKey12345"; // 16 bytes AES
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB

    private static final Set<ClientHandler> clients =
            ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {
        System.out.println("🔐 SecureChat Server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    /* ================= CLIENT HANDLER ================= */

    static class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private DataInputStream dataIn;
        private DataOutputStream dataOut;

        private String username;
        private boolean authenticated = false;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());

                /* ---------- AUTH ---------- */
                out.println("WELCOME");
                username = in.readLine();

                out.println("PASSWORD");
                String password = in.readLine();

                if (!authenticate(username, password)) {
                    out.println("AUTH_FAILED");
                    close();
                    return;
                }

                authenticated = true;
                out.println("AUTH_SUCCESS");
                broadcastSystem(username + " joined the chat");

                System.out.println("✅ " + username + " authenticated");

                /* ---------- MESSAGE LOOP ---------- */
                String input;
                while ((input = in.readLine()) != null) {

                    if (input.startsWith("FILE_TRANSFER:")) {
                        handleFileTransfer(input);
                    } else {
                        String decrypted = decrypt(input);
                        if (decrypted.equalsIgnoreCase("/quit")) break;

                        System.out.println("[" + username + "]: " + decrypted);
                        broadcastMessage(username, decrypted);
                    }
                }

            } catch (Exception e) {
                System.err.println("Client error: " + e.getMessage());
            } finally {
                close();
            }
        }

        /* ================= FILE HANDLING ================= */

        private void handleFileTransfer(String header) throws IOException {
            // FILE_TRANSFER:filename:size
            String[] parts = header.split(":", 3);
            String filename = parts[1];
            long size = Long.parseLong(parts[2]);

            if (size > MAX_FILE_SIZE) {
                out.println("ERROR|File too large");
                return;
            }

            byte[] data = new byte[(int) size];
            dataIn.readFully(data);

            System.out.println("📁 " + username + " sent file: " + filename);

            broadcastFile(username, filename, data);
        }

        private void broadcastFile(String sender, String filename, byte[] data) {
            String header = "FILE_RECEIVED:" + sender + ":" + filename + ":" + data.length;

            for (ClientHandler c : clients) {
                if (c != this && c.authenticated) {
                    try {
                        c.out.println(header);
                        c.dataOut.write(data);
                        c.dataOut.flush();
                    } catch (IOException e) {
                        System.err.println("File send failed to " + c.username);
                    }
                }
            }
        }

        /* ================= BROADCAST ================= */

        private void broadcastMessage(String sender, String message) {
            String encrypted = encrypt(sender + "|" + message);
            for (ClientHandler c : clients) {
                if (c != this && c.authenticated) {
                    c.out.println(encrypted);
                }
            }
        }

        private void broadcastSystem(String msg) {
            String encrypted = encrypt("SYSTEM|" + msg);
            for (ClientHandler c : clients) {
                if (c.authenticated) c.out.println(encrypted);
            }
        }

        /* ================= AUTH ================= */

        private boolean authenticate(String user, String pass) {
            Map<String, String> users = Map.of(
                    "alice", "pass123",
                    "bob", "secure456",
                    "admin", "admin789"
            );
            return users.containsKey(user) && users.get(user).equals(pass);
        }

        /* ================= CRYPTO ================= */

        private String encrypt(String msg) {
            try {
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE,
                        new SecretKeySpec(SECRET_KEY.getBytes(), "AES"));
                return Base64.getEncoder()
                        .encodeToString(cipher.doFinal(msg.getBytes()));
            } catch (Exception e) {
                return msg;
            }
        }

        private String decrypt(String enc) {
            try {
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE,
                        new SecretKeySpec(SECRET_KEY.getBytes(), "AES"));
                return new String(cipher.doFinal(
                        Base64.getDecoder().decode(enc)));
            } catch (Exception e) {
                return enc;
            }
        }

        /* ================= CLEANUP ================= */

        private void close() {
            try {
                clients.remove(this);
                if (username != null && authenticated) {
                    broadcastSystem(username + " left the chat");
                }
                socket.close();
                System.out.println("❌ " + username + " disconnected");
            } catch (IOException ignored) {}
        }
    }
}
