package ooad.creationalpattern.morningclass.factorymethod;


// concrete product
public class DataConnection
        implements ConnectionProduct{
    private String host;
    private String user;
    private String password;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }
}

