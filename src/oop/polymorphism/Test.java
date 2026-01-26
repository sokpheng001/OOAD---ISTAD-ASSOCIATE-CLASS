package oop.polymorphism;

// Runtime polymorphism
class User{
    public void run(){
        System.out.println("User is running");
    }
}
class Customer extends User{
    @Override
    public void run() {
        System.out.println("Customer is running");
    }
}
class Admin extends User{
    @Override
    public void run() {
        System.out.println("Admin is running");
    }
}
// compile time polymorphism
class MathUtils{
    public int sum(int a, int b){
        return a+b;
    }
    public double sum(double a, double b){
        return a+b;
    }
}

public class Test {
    public static void main(String[] args) {
        Customer user1 = new Customer();
        User user2 = new User();
        User user3 = new Admin();
        user1.run();
        user2.run();
        user3.run();
    }
}
