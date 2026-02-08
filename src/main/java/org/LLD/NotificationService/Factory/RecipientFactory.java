package org.LLD.NotificationService.Factory;

import org.LLD.NotificationService.Exception.WrongNotificationTypeException;
import org.LLD.NotificationService.Model.EmailRecipient;
import org.LLD.NotificationService.Model.NotificationType;
import org.LLD.NotificationService.Model.Recipient;
import org.LLD.NotificationService.Model.SMSRecipient;

import java.util.List;

public class RecipientFactory {

    public static Recipient getRecipient(NotificationType notificationType, List<String> recipients, List<String> cc, List<String> bcc, String traiId, String contactNumber) {

        return switch (notificationType.name().toUpperCase()) {
            case "EMAIL" -> new EmailRecipient(recipients, cc, bcc);
            case "SMS" -> new SMSRecipient(traiId, contactNumber);
            default -> throw new WrongNotificationTypeException();
        };
    }
}
