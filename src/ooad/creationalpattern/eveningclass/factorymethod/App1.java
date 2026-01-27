package ooad.creationalpattern.eveningclass.factorymethod;

import ooad.creationalpattern.eveningclass
        .factorymethod.extendfeature.EmailSender;
import ooad.creationalpattern
        .eveningclass.factorymethod.extendfeature.EmailSenderCreator;

public class App1 {
    public static void main(String[] args) {
        EmailSenderCreator emailSenderCreator = new EmailSenderCreator();
        EmailSender emailSender = (EmailSender)
                emailSenderCreator.getInstance();
        emailSender.send();
    }
}
