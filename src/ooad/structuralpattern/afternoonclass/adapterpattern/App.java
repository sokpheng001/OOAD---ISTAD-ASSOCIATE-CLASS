package ooad.structuralpattern.afternoonclass.adapterpattern;

public class App {
    public static void main(String[] args) {
        double dollar = 50.0;
        BankingService bankingService
                 = new BankingServiceImpl();
        bankingService.payAsDollar(dollar);
        // pay as riel
        BankingService bankingService1
                 = new PaymentAdapter();
        bankingService1.payAsDollar(dollar);

    }
}
