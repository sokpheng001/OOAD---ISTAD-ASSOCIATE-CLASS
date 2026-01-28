package ooad.creationalpattern.afternoonclass.factorymethod;

// creator
public abstract class DataConnectionCreator {
    // factory method
    public abstract DatabaseConnection
    getDatabaseConnectionInstance();
}
