package ooad.structuralpattern.eveningclass.adapterpattern;

import ooad.structuralpattern.eveningclass.adapterpattern.practice.*;
import ooad.structuralpattern.eveningclass.adapterpattern.practice.PaymentAdapter;

public class App {
    public static void main(String[] args) {
        double dollar = 5000.0;
        Account account
                 = new Account();
        account.setAccountName("pisethkoko");
        account.setAccountNumber("888-888-888-888");
        account.setBalance(dollar);
        PaymentService dollarPayment
                 = new BankingService(account);
        dollarPayment.payAsDollar(10.0);
        // Piseth គាត់ចង់ pay ជា dollar តែទូទាត់ជា riel
        RielCurrencyPayment rielCurrencyPayment =
                 new RielPaymentConfig(account);
        PaymentService paymentAdapter =
                new PaymentAdapter(rielCurrencyPayment);
        paymentAdapter.payAsDollar(10.0);
        System.out.println(account.getBalance() + " $");
    }
}
