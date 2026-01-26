package ooad.creationalpattern.afternoonclass.factorymethodpractice.ecommerce;

public class NotificationServiceFactory
        extends ECommerceServiceCreator{
    @Override
    public ECommerceService getInstance() {
        return new NotificationService();
    }
}
