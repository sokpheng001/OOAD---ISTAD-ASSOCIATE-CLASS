package ooad.structuralpattern.eveningclass.adapterpattern;

public class App {
    public static void main(String[] args) {
        int cents = 5000;
        PaymentProcessor creditPayment = new CreditPayment();
        creditPayment.pay(cents);
        // calling adapter
        PayPalPayment payPalPayment = new PayPalPayment();
        PaymentProcessor paymentAdapter =
                new PaymentAdapter(payPalPayment);
        paymentAdapter.pay(cents);
    }
}
