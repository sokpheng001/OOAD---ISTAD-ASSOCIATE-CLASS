package ooad.creationalpattern.afternoonclass.factorymethod;
// concrete builder
public class PostgreSQLDatabaseConnectionCreator
        extends DataConnectionCreator{
    // factory method
    @Override
    public DatabaseConnection getDatabaseConnectionInstance() {
        PostgreSQLConnection postgreSQLConnection
                = new PostgreSQLConnection();
        postgreSQLConnection.setHost("jdbc://localhost:4321");
        postgreSQLConnection.setPassword("psotgres");
        postgreSQLConnection.setUserName("234");
        return postgreSQLConnection;
    }
}
