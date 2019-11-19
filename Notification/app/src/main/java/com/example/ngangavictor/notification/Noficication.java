package com.example.ngangavictor.notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Noficication extends Application {
    /*
    * This class will start when the application starts.
    * It will create channels as needed by api 26+
    * */
    //declare some constants here
    public static final String CHANNEL_1 = "channel1";
    public static final String CAHNNEL_2 = "channel2";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_1,
                    "First Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationChannel.setDescription("This is channel 1");
            NotificationChannel notificationChannel1 = new NotificationChannel(
                    CAHNNEL_2,
                    "Second channel",
                    NotificationManager.IMPORTANCE_LOW
            );
            notificationChannel1.setDescription("This is channel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
            manager.createNotificationChannel(notificationChannel1);
        }
    }
}
