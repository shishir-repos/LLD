package org.LLD.NotificationService;

import org.LLD.NotificationService.Model.Notification;
import org.LLD.NotificationService.Factory.NotificationFactory;
import org.LLD.NotificationService.Factory.RecipientFactory;
import org.LLD.NotificationService.Model.NotificationType;
import org.LLD.NotificationService.Model.Recipient;
import org.LLD.NotificationService.Service.NotificationService;

import java.util.List;

public class Runner {


    public static void main(String[] args) throws InterruptedException {
        NotificationService notificationService = new NotificationService(2, 2);

        Recipient recipient = RecipientFactory.getRecipient(NotificationType.EMAIL, List.of("shishir", "prashi"), List.of("shishirmac"), List.of(), "", "");
        Notification n = NotificationFactory.getNotification(NotificationType.EMAIL, recipient, "error");

        notificationService.submitNotification(n);

        Thread.sleep(3000);
        recipient = RecipientFactory.getRecipient(NotificationType.EMAIL, List.of("shishir", "prashi"), List.of("shishirmac"), List.of(), "", "");
        n = NotificationFactory.getNotification(NotificationType.EMAIL, recipient, "");
        notificationService.submitNotification(n);

        Thread.sleep(1000);
        notificationService.shutdown();

        System.out.println(Thread.activeCount());
    }
}
