package org.LLD.NotificationService.Factory;


import org.LLD.NotificationService.Exception.WrongNotificationTypeException;
import org.LLD.NotificationService.Model.*;


public class NotificationFactory {


    public static Notification getNotification(NotificationType notificationType, Recipient recipient, String message) {


        return switch (notificationType.name().toUpperCase()) {
            case "EMAIL" -> new EmailNotification(recipient, message);
            case "SMS" -> new EmailRecipient.SMSNotification(recipient, message);
            default -> throw new WrongNotificationTypeException();
        };
    }
}

