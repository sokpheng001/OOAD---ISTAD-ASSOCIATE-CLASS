package ooad.structuralpattern.eveningclass.adapterpattern;

// service
public class PayPalPayment {
    public void pay(double dollar){
        System.out.println("Paid: " + dollar + " $");
    }
}
