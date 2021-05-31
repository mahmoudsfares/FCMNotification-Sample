package com.example.notificationtester;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.notificationtester.notifications_pack.ApiService;
import com.example.notificationtester.notifications_pack.Data;
import com.example.notificationtester.notifications_pack.Message;
import com.example.notificationtester.notifications_pack.MyResponse;
import com.example.notificationtester.notifications_pack.NotificationSender;
import com.example.notificationtester.notifications_pack.RetrofitClient;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        printToken();

        Button sendBtn = findViewById(R.id.send_notif_btn);
        EditText tokenEt = findViewById(R.id.token_et);

        sendBtn.setOnClickListener(v -> sendNotification(tokenEt.getText().toString()));
    }

    /**
     * print token in the logs to use it to send a message to this device from another one using this token
     */
    private void printToken(){
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.w("myToken", "Fetching FCM registration token failed", task.getException());
                return;
            }
            // Get new FCM registration token
            String token = task.getResult();

            Log.d("myToken", token);
        });
    }


    private void sendNotification(String token){
        ApiService notificationsService = RetrofitClient.getClient("https://fcm.googleapis.com/").create(ApiService.class);
        Message message = new Message(1, "id01", 0, Calendar.getInstance().getTimeInMillis(),
                "this is the message body");
        Gson gson = new Gson();
        String messageJson = gson.toJson(message);
        Data data = new Data("message title", messageJson);
        NotificationSender sender = new NotificationSender(data, token);
        notificationsService.sendNotification(sender).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) { }
            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) { }
        });
    }
}