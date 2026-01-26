package ooad.creationalpattern.morningclass.prototype;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        Minion minion1 = new Minion(1,
                100.0,
                100,
                3,
                4,
                "RED");
        Minion minion2 =(Minion) minion1.clone();
        minion2.setColor("BLUE");
        minion2.setId(2);
        System.out.println("Minion1: " + minion1);
        System.out.println("Minion2: " + minion2);
    }
}
