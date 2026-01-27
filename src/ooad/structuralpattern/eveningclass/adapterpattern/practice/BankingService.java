package ooad.structuralpattern.eveningclass.adapterpattern.practice;

public class BankingService implements PaymentService{
    private Account account;
    public BankingService(Account account){
        this.account = account;
    }
    @Override
    public boolean payAsDollar(double cash) {
        if(account==null){
            throw new RuntimeException("Account is null," +
                    " please check the account Object");
        }
        double totalCash = account.getBalance();
        double newBalanceStatus = totalCash-cash;
        account.setBalance(newBalanceStatus);
        System.out.println("Paid successfully: " + cash + " $");
        return true;
    }
}
