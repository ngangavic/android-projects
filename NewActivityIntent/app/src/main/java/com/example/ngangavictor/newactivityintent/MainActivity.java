package com.example.ngangavictor.newactivityintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button buttonSbmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openSecondActivity();
    }

    public void openSecondActivity(){
        buttonSbmt = (Button)findViewById(R.id.button);
        buttonSbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.ngangavictor.newactivityintent.Main2Activity");
                startActivity(intent);
            }
        });
    }
}
