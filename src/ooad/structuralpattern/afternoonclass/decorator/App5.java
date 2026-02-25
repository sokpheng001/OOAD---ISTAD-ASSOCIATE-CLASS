package ooad.structuralpattern.afternoonclass.decorator;

import java.io.BufferedReader;
import java.io.FileReader;

// components
abstract class Item {
    abstract void make();
}
// concrete component
class Coffee extends Item{
    private Double degree;
    private Boolean isHot;
    @Override
    void make() {
        degree = 1.0;
        isHot = true;
        System.out.println("Make simple coffee");
        System.out.println("Info: ");
        System.out.println("Degree: "  + degree);;
        System.out.println("Is Hot: " + isHot);
    }
}
class Tea extends Item{
    @Override
    void make() {
        System.out.println("Make simple tea");
        System.out.println("Hot");
    }
    ///
}
// base decorator
class BeverageDecorator extends Item{
    protected Item item;
    public BeverageDecorator(Item item){
        this.item = item;
    }
    @Override
    void make() {
        item.make();
    }
}
// concrete decorator
class Milk extends BeverageDecorator {
    public Milk(Item item) {
        super(item);
    }
    @Override
    void make() {
        super.make();
        extra();
    }
    private void extra(){
        System.out.println("Added milk to beverage");
    }
}

public class App5 {
    public static void main(String[] args) throws Exception{
        FileReader fileReader = new FileReader("C://data//file.txt");
        fileReader.read();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.read();
    }
}
