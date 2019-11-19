package com.example.ngangavictor.smsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToInbox(View view){
        Intent intent = new Intent(MainActivity.this,ActivityReceiveSMS.class);
        startActivity(intent);
    }

    public void goToSend(View view){
        Intent intent = new Intent(MainActivity.this,ActivitySendSMS.class);
        startActivity(intent);
    }
}
