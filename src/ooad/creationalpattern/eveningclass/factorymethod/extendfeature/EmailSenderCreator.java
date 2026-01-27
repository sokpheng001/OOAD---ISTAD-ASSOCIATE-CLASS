package ooad.creationalpattern.eveningclass.factorymethod.extendfeature;

import ooad.creationalpattern.eveningclass.factorymethod.ApplicationService;
import ooad.creationalpattern.eveningclass.factorymethod.ServiceCreator;

// concrete creator
public class EmailSenderCreator extends ServiceCreator {
    @Override
    public ApplicationService getInstance() {
        EmailSender emailSender =new EmailSender();
        emailSender.config("piseth123@2gmail.com","" +
                "menglong123@2gmail.com","DSFGFDBCSDsdfssdsf",
                "Menglong Keo");
        return emailSender;
    }
}
