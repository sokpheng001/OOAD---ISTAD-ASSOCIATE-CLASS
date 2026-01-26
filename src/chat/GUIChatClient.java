package chat;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.imageio.ImageIO;
import java.nio.file.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class GUIChatClient extends JFrame {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;
    private static final String SECRET_KEY = "MySecretKey12345";
    private static final String DOWNLOAD_DIR = "downloads/";

    private static final Color BG_PRIMARY = new Color(18,18,18);
    private static final Color BG_SECONDARY = new Color(28,28,30);
    private static final Color BG_TERTIARY = new Color(44,44,46);
    private static final Color ACCENT_BLUE = new Color(10,132,255);
    private static final Color ACCENT_GREEN = new Color(52,199,89);
    private static final Color TEXT_PRIMARY = Color.WHITE;
    private static final Color TEXT_SECONDARY = new Color(152,152,157);
    private static final Color MSG_SENT = new Color(48,48,52);
    private static final Color MSG_RECEIVED = new Color(58,58,62);

    private JPanel chatMessagesPanel;
    private JScrollPane chatScrollPane;
    private JTextField messageField;
    private JButton sendButton, attachButton;
    private JPanel loginPanel, chatPanel;
    private JLabel statusLabel;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;

    private String username;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public GUIChatClient() {
        setTitle("SecureChat");
        setSize(900,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        new File(DOWNLOAD_DIR).mkdirs();

        createLoginPanel();
        createChatPanel();
        add(loginPanel);

        setVisible(true);
    }

    /* ---------------- LOGIN PANEL ---------------- */

    private void createLoginPanel() {
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(BG_PRIMARY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        JLabel title = new JLabel("🔐 SecureChat");
        title.setFont(new Font("Segoe UI",Font.BOLD,32));
        title.setForeground(TEXT_PRIMARY);

        gbc.gridwidth = 2;
        loginPanel.add(title, gbc);

        gbc.gridy = 1;
        JTextField userField = new JTextField(20);
        loginPanel.add(userField, gbc);

        gbc.gridy = 2;
        JPasswordField passField = new JPasswordField(20);
        loginPanel.add(passField, gbc);

        gbc.gridy = 3;
        JButton loginBtn = new JButton("Sign In");
        loginPanel.add(loginBtn, gbc);

        gbc.gridy = 4;
        statusLabel = new JLabel("");
        statusLabel.setForeground(Color.RED);
        loginPanel.add(statusLabel, gbc);

        loginBtn.addActionListener(e ->
                connectToServer(userField.getText(), new String(passField.getPassword())));
    }

    /* ---------------- CHAT PANEL ---------------- */

    private void createChatPanel() {
        chatPanel = new JPanel(new BorderLayout());
        chatPanel.setBackground(BG_PRIMARY);

        chatMessagesPanel = new JPanel();
        chatMessagesPanel.setLayout(new BoxLayout(chatMessagesPanel, BoxLayout.Y_AXIS));
        chatMessagesPanel.setBackground(BG_PRIMARY);

        chatScrollPane = new JScrollPane(chatMessagesPanel);
        chatScrollPane.setBorder(null);

        messageField = new JTextField();
        sendButton = new JButton("Send");
        attachButton = new JButton("📎");

        JPanel input = new JPanel(new BorderLayout(5,5));
        input.add(attachButton, BorderLayout.WEST);
        input.add(messageField, BorderLayout.CENTER);
        input.add(sendButton, BorderLayout.EAST);

        chatPanel.add(chatScrollPane, BorderLayout.CENTER);
        chatPanel.add(input, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());
        attachButton.addActionListener(e -> selectAndSendFile());
    }

    /* ---------------- CONNECTION ---------------- */

    private void connectToServer(String user, String pass) {
        new Thread(() -> {
            try {
                socket = new Socket(SERVER_HOST, SERVER_PORT);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());

                out.println(user);
                out.println(pass);

                String response = in.readLine();
                if ("AUTH_SUCCESS".equals(response)) {
                    username = user;
                    SwingUtilities.invokeLater(() -> {
                        remove(loginPanel);
                        add(chatPanel);
                        revalidate();
                        repaint();
                    });
                    new Thread(new MessageReceiver()).start();
                } else {
                    statusLabel.setText("Login failed");
                }
            } catch (IOException e) {
                statusLabel.setText("Connection error");
            }
        }).start();
    }

    /* ---------------- MESSAGE HANDLING ---------------- */

    private void sendMessage() {
        String msg = messageField.getText().trim();
        if (msg.isEmpty()) return;

        out.println(encrypt(msg));
        addChatMessage(username, msg, true);
        messageField.setText("");
    }

    private void addChatMessage(String sender, String msg, boolean own) {
        JPanel p = new JPanel(new FlowLayout(own ? FlowLayout.RIGHT : FlowLayout.LEFT));
        JLabel l = new JLabel("<html><b>"+sender+":</b> "+msg+"</html>");
        l.setForeground(TEXT_PRIMARY);
        p.setBackground(BG_PRIMARY);
        p.add(l);
        chatMessagesPanel.add(p);
        chatMessagesPanel.revalidate();
        scrollToBottom();
    }

    private void scrollToBottom() {
        SwingUtilities.invokeLater(() -> {
            JScrollBar sb = chatScrollPane.getVerticalScrollBar();
            sb.setValue(sb.getMaximum());
        });
    }

    /* ---------------- FILE & IMAGE ---------------- */

    private void selectAndSendFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            new Thread(() -> sendFile(chooser.getSelectedFile())).start();
        }
    }

    private void sendFile(File file) {
        try {
            byte[] data = Files.readAllBytes(file.toPath());
            out.println("FILE:" + file.getName() + ":" + data.length);
            dataOut.write(data);
            dataOut.flush();
            addChatMessage(username, "[Sent file] " + file.getName(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ---------------- RECEIVER ---------------- */

    private class MessageReceiver implements Runnable {
        public void run() {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    if (msg.startsWith("FILE:")) {
                        receiveFile(msg);
                    } else {
                        addChatMessage("Friend", decrypt(msg), false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void receiveFile(String header) throws Exception {
        String[] p = header.split(":");
        String name = p[1];
        int size = Integer.parseInt(p[2]);

        byte[] data = dataIn.readNBytes(size);
        Files.write(Paths.get(DOWNLOAD_DIR + name), data);
        addChatMessage("Friend", "[Received file] " + name, false);
    }

    /* ---------------- CRYPTO ---------------- */

    private String encrypt(String text) {
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(), "AES"));
            return Base64.getEncoder().encodeToString(c.doFinal(text.getBytes()));
        } catch (Exception e) { return text; }
    }

    private String decrypt(String text) {
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(), "AES"));
            return new String(c.doFinal(Base64.getDecoder().decode(text)));
        } catch (Exception e) { return text; }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIChatClient::new);
    }
}
