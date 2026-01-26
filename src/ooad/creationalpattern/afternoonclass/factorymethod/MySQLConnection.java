package ooad.creationalpattern.afternoonclass.factorymethod;

import lombok.Setter;

// concreteProduct
@Setter
public class MySQLConnection implements DatabaseConnection{
    private String url;
    @Override
    public Object getConnection() {
        if(url!=null){
            return true;
        }
        return false;
    }
}
