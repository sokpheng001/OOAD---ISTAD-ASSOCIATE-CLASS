package ooad.structuralpattern.afternoonclass.adapterpattern;

public class BankingServiceImpl implements BankingService{
    @Override
    public void payAsDollar(double dollar) {
        System.out.println("Paid as dollar: " + dollar + " $");
    }
}
