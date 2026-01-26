package ooad.creationalpattern.afternoonclass.factorymethod;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        PostgreSQLDatabaseConnectionCreator
                postgreSQL
                = new PostgreSQLDatabaseConnectionCreator();
        DatabaseConnection postgreSQLConnection = postgreSQL
                .getDatabaseConnectionInstance();
        System.out.println(postgreSQLConnection.getConnection());
    }
}
