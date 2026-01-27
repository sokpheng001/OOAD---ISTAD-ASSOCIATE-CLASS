package ooad.structuralpattern.eveningclass.adapterpattern.practice;

public class RielPaymentConfig implements RielCurrencyPayment{
    private final Account account;
    public RielPaymentConfig(Account account){
        this.account = account;
    }
    @Override
    public boolean payAsRiel(double riel) {
        double dollar = riel /4000;
        double totalCashAsDollar = account.getBalance();
        double newUpdateBalance = totalCashAsDollar-dollar;
        account.setBalance(newUpdateBalance);
        return true;
    }
}
