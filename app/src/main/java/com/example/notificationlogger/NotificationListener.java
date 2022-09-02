package com.example.notificationlogger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class NotificationListener extends NotificationListenerService {
    public NotificationListener() {}

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onNotificationPosted (StatusBarNotification sbn) {
        Bundle b = sbn.getNotification().extras;
        sendMessageToActivity(b);
    }

    private void sendMessageToActivity(Bundle b) {
        Intent intent = new Intent("ReceivedNotification");
        intent.putExtra("Notification", b);
        sendBroadcast(intent);
    }
}