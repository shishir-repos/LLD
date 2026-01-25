package org.LLD.DesignPatterns.Factory;

public class NotificationFactory {

    public static Notification getNotificationObject(String channel) {
        if (channel == null || channel.isEmpty()) return null;
        return switch (channel) {
            case "EMAIL" -> new EmailNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown channel");
        };
    }
}
