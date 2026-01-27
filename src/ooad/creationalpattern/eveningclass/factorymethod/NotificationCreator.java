package ooad.creationalpattern.eveningclass.factorymethod;

import java.time.Instant;
import java.util.Date;

// concrete creator
public class NotificationCreator
        extends ServiceCreator{
    // factory method
    @Override
    public ApplicationService getInstance() {
        NotificationService notificationService = new NotificationService();
        notificationService.setTimestamp(Date.from(Instant.now()));
        notificationService.setId("Notification Service Object");
        return notificationService;
    }
}
