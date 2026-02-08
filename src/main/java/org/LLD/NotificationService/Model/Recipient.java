package org.LLD.NotificationService.Model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class Recipient {
    protected NotificationType notificationType;

    public abstract String getPrimaryRecipient();
}
