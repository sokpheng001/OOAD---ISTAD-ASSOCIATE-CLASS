package ooad.creationalpattern.morningclass;

import java.util.UUID;


class User{
    private static User instance;
    private String uuid;
    private User(String uuid){
        this.uuid = uuid;
    }
    public static User getInstance(){
        if(instance==null){
            instance = new User(UUID.randomUUID().toString());
        }
        return instance;
    }
    public String getUuid() {
        return uuid;
    }
}

public class SingletonDemo{
    public static void main(String[] args) {
        User user1 = User.getInstance();
        User user2 = User.getInstance();
        User user3 = User.getInstance();
        User user4 = User.getInstance();
        User user5 = User.getInstance();
        User user6 = User.getInstance();
        System.out.println(user1.getUuid());
        System.out.println(user2.getUuid());
        System.out.println(user3.getUuid());
        System.out.println(user4.getUuid());
        System.out.println(user5.getUuid());
        System.out.println(user6.getUuid());
    }
}
