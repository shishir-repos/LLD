package org.LLD.NotificationService.Model;

import java.util.logging.Logger;

public class EmailNotification extends Notification {

    Logger logger = Logger.getLogger(EmailNotification.class.getName());

    public EmailNotification(Recipient recipient, String message) {
        super(recipient, message);
    }

    @Override
    public void send() {
        logger.info("Sent Email Notification for: " + this.recipient);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

