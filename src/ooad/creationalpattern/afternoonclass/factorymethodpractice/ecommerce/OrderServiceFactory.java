package ooad.creationalpattern.afternoonclass.factorymethodpractice.ecommerce;

public class OrderServiceFactory
        extends ECommerceServiceCreator{
    @Override
    public ECommerceService getInstance() {
        return new OrderService();
    }
}
