package com.example.notificationlogger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messages = new ArrayList<>();
        setContentView(R.layout.activity_main);
        Log.d("LOGTEST", "logging works");
    }

    @Override
    protected void onResume() {
        super.onResume();
        BroadcastReceiver br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // messages.add(intent.getExtras().getCharSequence(Notification.EXTRA_TEXT).toString());
                Log.d("NOTIFICATION", "Received Notification");
                // Log.d("NOTIFICATION", intent.getExtras().getCharSequence(Notification.EXTRA_TEXT).toString());
            }
        };
        registerReceiver(br, new IntentFilter("ReceivedNotification"));
    }
}