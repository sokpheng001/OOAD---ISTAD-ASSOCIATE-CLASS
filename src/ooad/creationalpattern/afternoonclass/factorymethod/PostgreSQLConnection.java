package ooad.creationalpattern.afternoonclass.factorymethod;

import lombok.Setter;

// concreteProduct
@Setter
public class PostgreSQLConnection implements DatabaseConnection {
    private String host;
    private String password;
    private String userName;

    @Override
    public Object getConnection() {
        if(host!=null && password!=null && userName!=null){
            return true;
        }
        return false;
//        return url != null
//                && password != null
//                && userName != null;
    }
    //
}
