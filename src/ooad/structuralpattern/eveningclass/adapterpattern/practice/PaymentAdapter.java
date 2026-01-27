package ooad.structuralpattern.eveningclass.adapterpattern.practice;

// adapter
public class PaymentAdapter implements PaymentService{
    private final RielCurrencyPayment rielCurrencyPayment;
    public PaymentAdapter(RielCurrencyPayment rielCurrencyPayment){
        this.rielCurrencyPayment = rielCurrencyPayment;
    }
    @Override
    public boolean payAsDollar(double cash) {
        if(rielCurrencyPayment==null){
            throw new RuntimeException("RielCurrencyPayment Object is null.");
        }
        double riel = cash * 4000;
        rielCurrencyPayment.payAsRiel(riel);
        System.out.println("Paid successfully: " + riel + " riel");
        return true;
    }
}
