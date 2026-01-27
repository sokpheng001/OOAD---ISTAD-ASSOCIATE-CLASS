package ooad.structuralpattern.morningclass.adapterpattern;

// client interface
interface PaymentProcessor{
    void pay(int cents);
}
class CreditCardPayment implements PaymentProcessor{
    @Override
    public void pay(int cents) {
        // ..
        System.out.println("Paid for " + cents + " cents");
    }
}
// service - third party library
class PaypalPayment {
    void pay(double dollar){
        System.out.println("Paid for " + dollar + " $");
    }
}
// adapter

class PaymentAdapter implements PaymentProcessor{
    private PaypalPayment adaptee;
    public PaymentAdapter(PaypalPayment adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void pay(int cents) {
        // logic convert or adapt
        double dollar = cents * 0.01;
        adaptee.pay(dollar);
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        int cents = 5000;
        PaymentProcessor credit = new CreditCardPayment();
        credit.pay(cents);
        PaymentProcessor payPal = new PaymentAdapter(
                new PaypalPayment()
        );
        payPal.pay(cents);

    }
}
