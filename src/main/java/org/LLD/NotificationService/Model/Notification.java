package org.LLD.NotificationService.Model;

import lombok.Getter;
import org.LLD.NotificationService.Factory.Sendable;


import java.time.LocalDateTime;


@Getter
public abstract class Notification implements Sendable {

    protected Recipient recipient;
    protected String message;
    protected LocalDateTime timeStamp;


    public Notification(Recipient recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }
}

