package oop.polymorphism;

import lombok.Data;

import java.time.LocalDate;
@Data
class Account{
    private Integer id;
    private String accountName;
    private String accountNumber;
    private LocalDate expireDate;
    private Double cash = 0.0;
}
class SavingAccount extends Account{

}
class CreditCardAccount extends Account{
    private String cvv;
}
abstract class BankingService{
    public abstract void deposit(Account account, Double amount);
    public abstract void withdraw(Account account, Double amount);
    abstract void showBalance(Account account);
}
class BankingServiceImpl extends BankingService{

    @Override
    public void deposit(Account account, Double amount) {
        if(amount<=0){
            System.out.println("Invalid cash amount");
            return;
        }
        Double oldCashAmount = account.getCash();
        account.setCash(oldCashAmount+amount);
        System.out.println("Successfully deposit " +
                amount + "$ to account number: " + account.getAccountNumber());
    }

    @Override
    public void withdraw(Account account, Double amount) {
        if(amount<=0 || amount>account.getCash()){
            System.out.println("Invalid cash number or balance is not enough");
            return;
        }
        Double totalCash = account.getCash();
        account.setCash(totalCash-amount);
        System.out.println("Successfully withdraw " +
                amount + "$ to account number: " + account.getAccountNumber());
    }
    @Override
    public void showBalance(Account account){
        System.out.println("=".repeat(20));
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getCash() + "$");
        System.out.println("=".repeat(20));
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Account account = new SavingAccount();
        Account creditCard = new CreditCardAccount();
        creditCard.setAccountNumber("323-234-2432-234");
        account.setAccountNumber("012-123-131-3122");
        BankingService bankingService = new BankingServiceImpl();
        //
        bankingService.deposit(account,100.0);
        bankingService.withdraw(account,10.0);
        //
        bankingService.deposit(creditCard,500.0);
    }
}
