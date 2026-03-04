package ooad.behavioralpattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

// currency exchange dollar & riel , observer pattern
// subscriber
abstract class Bank{
    protected String name;
    public Bank(String name){
        this.name = name;
    }
    abstract void update(String context);
}
// concrete subscriber
class ABABank extends Bank{
    public ABABank(String name) {
        super(name);
    }
    @Override
    public void update(String context) {
        System.out.println(name + ", Message: " + context);
    }
}
class ACledaBank extends Bank {
    public ACledaBank(String name) {
        super(name);
    }
    @Override
    public void update(String context) {
        System.out.println(name + ", Message: " + context);
    }
}
// publisher
class NationalBank{
    private List<Bank> banks = new ArrayList<>();
    private String currencyState;
    public void addBank(Bank bank){
        this.banks.add(bank);
    }
    public void removeBank(Bank bank){
        this.banks.remove(bank);
    }
    // notify method
    public void informCurrencyState(){
        // notify logic
        for(Bank banking: banks){
            banking.update(currencyState);
        }
    }
    //
    public void updateState(String context){
        this.currencyState = context;
    }
}
//client
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Bank aba = new ABABank("ABA Bank");
        Bank acleda = new ACledaBank("ACLEDA Bank");
        NationalBank nationalBank = new NationalBank();
        nationalBank.addBank(aba);
        nationalBank.addBank(acleda);
        nationalBank.updateState("1$ = 4100");
        nationalBank.informCurrencyState();
    }
}
