package ooad.structuralpattern.afternoonclass.adapterpattern;

// adapter
public class PaymentAdapter implements BankingService{
    private final RielCurrencyPayment adaptee =
            new RielCurrencyPayment();

    @Override
    public void payAsDollar(double dollar) {
        double riel = dollar*4000;
        adaptee.payAsRiel(riel);
    }
}
