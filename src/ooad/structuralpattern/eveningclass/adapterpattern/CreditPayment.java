package ooad.structuralpattern.eveningclass.adapterpattern;

// client-code
public class CreditPayment implements PaymentProcessor{
    @Override
    public void pay(int cents) {
        System.out.println("Paid: " + cents + " cents");
    }
}
