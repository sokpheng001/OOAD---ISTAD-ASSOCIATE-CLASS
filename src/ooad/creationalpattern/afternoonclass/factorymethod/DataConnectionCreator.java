package ooad.creationalpattern.afternoonclass.factorymethod;

public abstract class DataConnectionCreator {
    // factory method
    public abstract DatabaseConnection
    getDatabaseConnectionInstance();
}
