package com.example.notificationtester.notifications_pack;


/**
 * this class is essential for sending a notification, use it as it is
 */
public class Data {

    // names of these strings MUST be declared in that exact same spelling for serializing purposes
    private String Title;
    private String Message;

    public Data(String title, String message) {
        Title = title;
        Message = message;
    }

    public Data() { }
}
