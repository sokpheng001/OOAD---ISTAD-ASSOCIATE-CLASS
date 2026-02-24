package ooad.structuralpattern.morningclass.bridgepattern;

// implementation
interface PConnection{
    void connect(String url, String user, String password);
}
// implementation
class PostgresDriver implements PConnection{
    @Override
    public void connect(String url,
                        String user,
                        String password){
        // logic to connection to postgres
        System.out.println("Postgres connection");
    }
}
class MySQLDriver implements PConnection{
    @Override
    public void connect(String url, String user, String password) {
        // logic to mysql
        System.out.println("MySQL Connection");
    }
}
//abstraction
class PDriverConnection{
    // bridge
    private static PConnection pConnection;

    public static PConnection getConnection(
            String url,
            String user,
            String password
    ){
        if(url.contains("postgres")){
            pConnection = new PostgresDriver();
        }
        if(url.contains("mysql")){
            pConnection = new MySQLDriver();
        }
        if(url.contains("mogodb")){

        }
        pConnection.connect(url,user,password);
        //
        return null;
    }
}

public class App1 {
    public static void main(String[] args) {
        PConnection pConnection
                = PDriverConnection.getConnection(
                        "jdbc://mysql",
                "jame",
                "!23"
        );
    }
}
