package org.LLD.NotificationService.Model;

public class SMSRecipient extends Recipient {
    String traiId;
    String contactNumber;

    public SMSRecipient(String traiId, String contactNumber) {
        this.traiId = traiId;
        this.contactNumber = contactNumber;
        this.notificationType = NotificationType.SMS;
    }

    @Override
    public String getPrimaryRecipient() {
        return this.contactNumber;
    }
}
