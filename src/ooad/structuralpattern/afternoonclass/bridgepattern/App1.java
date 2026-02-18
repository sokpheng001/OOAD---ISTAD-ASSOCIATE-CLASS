package ooad.structuralpattern.afternoonclass.bridgepattern;
import java.util.Scanner;

// abstraction
abstract class Shape{
    // bridge
    private  Color color;
    public Shape(Color color){
        this.color = color;
    }
    public Shape(){}
    abstract public void draw();
}
class Rectangle extends Shape{
    public Rectangle(Color color) {
        super(color);
    }
    public Rectangle(){
        super();
    }
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
class Square extends Shape{
    public Square(Color color) {
        super(color);
    }
    public Square(){}
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}
// implementation
abstract class Color{
    public abstract String colorType();
}
class RED extends Color{
    @Override
    public String colorType() {
        return "RED COLOR";
    }
}
class BLUE extends Color{
    @Override
    public String colorType() {
        return "BLUE COLOR";
    }
}
//
// client
public class App1 {
    public static void main(String[] args) {
        Shape redRectangle = new Rectangle(new RED());
        Shape rectangle = new Rectangle();
        while (true){
            System.out.println("Insert option: ");
            int opt = new Scanner(System.in).nextInt();
            switch (opt){
                case 1->{rectangle = new Rectangle();}
                case 2->{rectangle = new Rectangle(new BLUE());}
            }
        }
    }
}
