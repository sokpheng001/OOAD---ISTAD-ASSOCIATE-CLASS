package ooad.creationalpattern.eveningclass.factorymethod.extendfeature;

import ooad.creationalpattern.eveningclass.factorymethod.ApplicationService;

// concrete product
public class EmailSender implements ApplicationService {
    private String email;
    private String sender;
    private String appPassword;
    private String userName;
    public void config(String email, String sender, String appPassword, String userName){
        //...
        this.appPassword = appPassword;
        this.email = email;
        this.userName = userName;
        this.sender = sender;
        //..
    }
    public void send(){
        if(appPassword!=null  && email!=null && sender!=null){
            System.out.println("Sent an email successfully");
        }else {
            throw new RuntimeException("Error in sending email");
        }
    }
}
