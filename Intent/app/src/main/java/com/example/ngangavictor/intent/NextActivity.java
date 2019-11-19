package com.example.ngangavictor.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
   TextView uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        uname = (TextView)findViewById(R.id.tvUsername);

        /*Intent intent = new Intent();
        Bundle bundle = intent.getExtras();
        String usernm = bundle.getString("user_name");*/
        //String usernm = intent.getStringExtra("user_name");
       // uname.setText(usernm);
        String s= getIntent().getStringExtra("user_name");
        uname.setText(s);
    }
}
