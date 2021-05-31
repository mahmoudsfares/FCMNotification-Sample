package com.example.notificationtester.notifications_pack;

public class Message {
    private int senderType;
    private String senderId;
    private int recipientType;
    private String recipientId;
    private long sendingTime;
    private String messageBody;

    public Message(int senderType, String senderId, int recipientType, long sendingTime, String messageBody) {
        this.senderType = senderType;
        this.senderId = senderId;
        this.recipientType = recipientType;
        this.sendingTime = sendingTime;
        this.messageBody = messageBody;
    }

    public int getSenderType() {
        return senderType;
    }

    public void setSenderType(int senderType) {
        this.senderType = senderType;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public int getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(int recipientType) {
        this.recipientType = recipientType;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public long getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(long sendingTime) {
        this.sendingTime = sendingTime;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
