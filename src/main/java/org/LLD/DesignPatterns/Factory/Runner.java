package org.LLD.DesignPatterns.Factory;

public class Runner {

    public static void main(String[] args) {
        Notification notification = NotificationFactory.getNotificationObject("EMAIL");
        notification.notifyUser();
        System.out.println();

        notification = NotificationFactory.getNotificationObject("PUSH");
        notification.notifyUser();
        System.out.println();

        String channel = "sms";
        try {
            notification = NotificationFactory.getNotificationObject(channel);
            notification.notifyUser();
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong input found -> "+channel);
        }
    }

}
