package com.example.notificationtester.notifications_pack;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;

import com.example.notificationtester.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    Message message;

    private static final String NOTIFICATION_CHANNEL_ID = "notif-channel";
    private static final String NOTIFICATION_CHANNEL_NAME = "Primary";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Gson gson = new Gson();
        message = gson.fromJson(remoteMessage.getData().get("Message"), Message.class);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // for android oreo and above, a notification should have a channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    NOTIFICATION_CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
            );
            manager.createNotificationChannel(notificationChannel);
            Notification.Builder builder = new Notification.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID)
                    // these are the basic 3 notification components, app will crash if one is missing
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                    .setContentTitle(message.getSendingTime()+"")
                    .setContentText(message.getMessageBody());
            manager.notify(0, builder.build());
        }

        // the new Builder constructor which takes the channel as a second parameter requires android oreo or above only
        // so if the sdk is below 26, the old Builder(context) constructor should be used
        else {
            Notification.Builder builder = new Notification.Builder(getApplicationContext())
                    // these are the basic 3 notification components, app will crash if one is missing
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                    .setContentTitle(message.getSendingTime()+"")
                    .setContentText(message.getMessageBody());
            manager.notify(0, builder.build());
        }
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }
}