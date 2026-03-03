package ooad.structuralpattern.morningclass.decorator;
import java.util.Scanner;

// component
interface Item{
    void make();
}
// concrete component
class Beverage implements Item{
    private String beverageName;
    private Double sugar;
    @Override
    public void make() {
        System.out.print("[+] Insert beverage name: ");
        beverageName = new Scanner(System.in).nextLine();
        System.out.print("[+] Insert sugar rate: ");
        sugar = new Scanner(System.in).nextDouble();
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Beverage{" +
                "beverageName='" + beverageName + '\'' +
                ", sugar=" + sugar +
                '}';
    }
}
// base decorator
class BeverageDecorator implements Item {
    private Item wrappee;
    public BeverageDecorator(Item c){
        this.wrappee =c;
    }
    @Override
    public void make() {
        wrappee.make();
    }
}
// concrete decorator
class MilkDecorator extends BeverageDecorator{
    public MilkDecorator(Item c) {
        super(c);
    }
    @Override
    public void make() {
        super.make();
        addingMilk();
    }
    // extra
    private void addingMilk(){
        System.out.println("Adding to milk to beverage");
    }
}
// concrete decorator2
class IceDecorator extends BeverageDecorator{
    public IceDecorator(Item c) {
        super(c);
    }
    @Override
    public void make() {
        super.make();
        addingIce();
    }
    // extra
    private void addingIce(){
        System.out.println("Adding to ice to beverage");
    }
}

public class App90 {
    public static void main(String[] args) {
        Beverage beverage = new Beverage();
        IceDecorator iceDecorator = new IceDecorator(beverage);
        iceDecorator.make();
    }
}
