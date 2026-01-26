package ooad.creationalpattern.afternoonclass.factorymethodpractice.ecommerce;

// Concrete Product
public class OrderService implements ECommerceService{
    public void makeAnOrder(Object order){
        // ...
    }
    public void cancelOrder(String id){
        //...
    }
    @Override
    public void operate() {
        System.out.println("Operate Order Service");
    }
}
