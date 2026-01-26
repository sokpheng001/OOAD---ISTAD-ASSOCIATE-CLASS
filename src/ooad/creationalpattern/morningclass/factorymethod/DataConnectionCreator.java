package ooad.creationalpattern.morningclass.factorymethod;

public class DataConnectionCreator
        extends ConnectionCreator{
    // factory method
    @Override
    public ConnectionProduct getInstance() {
        DataConnection dataConnection
                = new DataConnection();
        dataConnection.setHost("jdbc://localhost:4321");
        dataConnection.setUser("koko");
        dataConnection.setPassword("123");
        return dataConnection;
    }
}
