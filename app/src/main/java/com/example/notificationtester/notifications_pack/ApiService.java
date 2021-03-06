package com.example.notificationtester.notifications_pack;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @Headers(
            {
                    "Content-Type:application/json",
                    // TODO: replace the Xs with your FCM server key:
                    //  project settings -> cloud messaging -> server key
                    "Authorization:key=xxxxxxxxxxxxxxxx"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body NotificationSender body);
}