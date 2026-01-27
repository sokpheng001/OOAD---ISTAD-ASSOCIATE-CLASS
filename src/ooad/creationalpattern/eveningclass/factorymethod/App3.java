package ooad.creationalpattern.eveningclass.factorymethod;

public class App3 {
    public static void main(String[] args) {
        ServiceCreator serviceCreator
                = new NotificationCreator();
        NotificationService notification =
                (NotificationService) serviceCreator.getInstance();
        System.out.println(notification.getId());
    }
}
