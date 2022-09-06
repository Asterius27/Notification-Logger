package com.example.notificationlogger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class NotificationListener extends NotificationListenerService {
    public NotificationListener() {
        super();
    }

    @Override
    public void onListenerConnected () {
        super.onListenerConnected();
        Log.d("LISTENER", "connected");
        StatusBarNotification sbn = getActiveNotifications()[0];
        Log.d("NOTIFICATION", sbn.getPackageName());
    }

    @Override
    public void onNotificationPosted (StatusBarNotification sbn) {
        // Bundle b = sbn.getNotification().extras;
        sendMessageToActivity();
    }

    private void sendMessageToActivity() { // Bundle b
        Intent intent = new Intent("ReceivedNotification");
        // intent.putExtra("Notification", b);
        Log.d("NOTIFICATION POSTED", "sending broadcast...");
        sendBroadcast(intent);
    }
}