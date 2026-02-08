package org.LLD.NotificationService.Exception;

public class WrongNotificationTypeException extends RuntimeException {

    public WrongNotificationTypeException() {
        super("Wrong Notification Type Requested!");
    }
}

