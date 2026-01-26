package ooad.creationalpattern.morningclass.factorymethod;

public class App3 {
    public static void main(String[] args) {
        ConnectionCreator connectionCreator
                = new DataConnectionCreator();
        DataConnection dataConnection =
                (DataConnection) connectionCreator
                .getInstance();
    }
}
