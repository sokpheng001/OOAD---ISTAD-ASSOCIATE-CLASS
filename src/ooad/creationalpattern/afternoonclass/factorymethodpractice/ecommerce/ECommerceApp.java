package ooad.creationalpattern.afternoonclass.factorymethodpractice.ecommerce;

public class ECommerceApp {
    public static void main(String[] args) {
        ECommerceServiceCreator commerceServiceCreator
                 = new NotificationServiceFactory();
        NotificationService notification
                 = (NotificationService) commerceServiceCreator.getInstance();
        notification.operate();
        // Order
        ECommerceServiceCreator commerceServiceCreator1
                 = new OrderServiceFactory();
        ECommerceService order  =
                commerceServiceCreator1.getInstance();
        order.operate();
    }
}
