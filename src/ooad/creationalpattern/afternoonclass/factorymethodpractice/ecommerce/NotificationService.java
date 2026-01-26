package ooad.creationalpattern.afternoonclass.factorymethodpractice.ecommerce;

// Concrete Product
public class NotificationService
        implements ECommerceService{
    public void sendEmail(String sender, String receiver,
                          String message){
        //...
    }
    public void sendSMS(String receiver,
                        String content){
        //..
    }

    @Override
    public void operate() {
        System.out.println("Operate Notification Service");
    }
}
