package com.example.ngangavictor.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.ngangavictor.notification.Noficication.CAHNNEL_2;
import static com.example.ngangavictor.notification.Noficication.CHANNEL_1;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText mEditTextTitle,mEditTextMessage;
    private Button mButtonChannel1,mButtonChannel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextTitle = findViewById(R.id.editTextTitle);
        mEditTextMessage = findViewById(R.id.editTextMessage);
        mButtonChannel1 = findViewById(R.id.buttonChannel1);
        mButtonChannel2 = findViewById(R.id.buttonChannel2);
        notificationManagerCompat = NotificationManagerCompat.from(this);

        mButtonChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChannelOne();
            }
        });
        mButtonChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChannelTwo();
            }
        });
    }

    private void onChannelOne(){
        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        Intent broadcastIntent = new Intent(this,NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage",message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1)
                .setSmallIcon(R.drawable.ic_disc_full_black_24dp)
                .setContentTitle(title)
                .setContentInfo(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.RED)
                .setContentIntent(pendingIntent)
                .setAutoCancel(false)
                .addAction(R.drawable.ic_disc_full_black_24dp,"Toast",actionIntent)
                .build();
        notificationManagerCompat.notify(1,notification);
    }
    private void onChannelTwo(){
        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this,CAHNNEL_2)
                .setSmallIcon(R.drawable.ic_network_locked_black_24dp)
                .setContentTitle(title)
                .setContentInfo(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationManagerCompat.notify(2,notification);
    }
}
