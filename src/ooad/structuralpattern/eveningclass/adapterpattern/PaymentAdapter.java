package ooad.structuralpattern.eveningclass.adapterpattern;

// adapter
public class PaymentAdapter implements PaymentProcessor{
    // association relationship
    private final PayPalPayment adaptee;
    public PaymentAdapter (PayPalPayment payPalPayment){
        this.adaptee = payPalPayment;
    }
    @Override
    public void pay(int cents) {
        double dollar = cents * 0.01;
        adaptee.pay(dollar);
    }
}
