package ooad.structuralpattern.eveningclass.bridgepattern;

//
// abstraction
abstract class Shape{
    // bridge
    protected  final Color color;
    public Shape(Color color){
        this.color = color;
    }
    abstract public void draw();
}
class Rectangle extends Shape{
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with: " + color.paint());
    }
}
class Square extends Shape{
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square with " + color.paint());
    }
}
// implemnetation
abstract class Color{
    abstract public String paint();
}
class RED extends Color{
    @Override
    public String paint() {
        return "RED";
    }
}
class YELLOW extends Color{
    @Override
    public String paint() {
        return "YELLOW";
    }
}


public class ClientCod {
    public static void main(String[] args) {
      Shape rec = new Rectangle(new YELLOW());
      rec.draw();
    }
}
