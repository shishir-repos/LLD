package org.LLD.NotificationService.Model;

import lombok.Getter;

import java.util.List;

@Getter
public class EmailRecipient extends Recipient {
    List<String> recipients;
    List<String> cc;
    List<String> bcc;

    public EmailRecipient(List<String> recipients, List<String> cc, List<String> bcc) {
        this.recipients = recipients;
        this.cc = cc;
        this.bcc = bcc;
        this.notificationType = NotificationType.EMAIL;
    }


    @Override
    public String getPrimaryRecipient() {
        return this.recipients.get(0);
    }

    public static class SMSNotification extends Notification {


        public SMSNotification(Recipient recipient, String message) {
            super(new SMSRecipient("123", "9752510403"), message);
        }

        @Override
        public void send() {

        }
    }
}
