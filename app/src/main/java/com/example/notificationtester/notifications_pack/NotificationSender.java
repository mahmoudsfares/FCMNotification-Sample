package com.example.notificationtester.notifications_pack;

/**
 * this class is essential for sending a notification, use it as it is
 */
public class NotificationSender {

    private Data data;
    private String to;

    public NotificationSender(Data data, String to) {
        this.data = data;
        this.to = to;
    }

    public NotificationSender() { }
}
