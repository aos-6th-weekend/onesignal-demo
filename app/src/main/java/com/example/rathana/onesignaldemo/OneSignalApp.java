package com.example.rathana.onesignaldemo;

import android.app.Application;
import android.content.Intent;

import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

public class OneSignalApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .setNotificationOpenedHandler(notificationOpenedHandler)
                .init();

    }

    private OneSignal.NotificationOpenedHandler notificationOpenedHandler=new OneSignal.NotificationOpenedHandler() {
        @Override
        public void notificationOpened(OSNotificationOpenResult result) {

            JSONObject data=result.notification.payload.additionalData;
            String title= data.optString("title");
            String content=data.optString("content");

            Intent intent= new Intent(getApplicationContext(),MainActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("title",title);
            intent.putExtra("content",content);

            startActivity(intent);

        }
    };
}
