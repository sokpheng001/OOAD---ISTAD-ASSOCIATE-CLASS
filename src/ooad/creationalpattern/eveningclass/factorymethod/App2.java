package ooad.creationalpattern.eveningclass.factorymethod;

public class App2 {
    public static void main(String[] args) {
        ServiceCreator serviceCreator
                = new NotificationCreator();
        ApplicationService notification = serviceCreator.getInstance();
    }
}
