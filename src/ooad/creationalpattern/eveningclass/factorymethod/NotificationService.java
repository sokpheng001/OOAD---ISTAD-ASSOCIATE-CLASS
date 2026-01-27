package ooad.creationalpattern.eveningclass.factorymethod;

import java.util.Date;
// concrete product
public class NotificationService implements ApplicationService{
    private String to;
    private String message;
    private Date timestamp;
    private String id;
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setTimestamp(Date sentDate) {
        this.timestamp = sentDate;
    }

}
