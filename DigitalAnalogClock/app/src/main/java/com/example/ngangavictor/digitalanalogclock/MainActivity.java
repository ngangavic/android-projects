package com.example.ngangavictor.digitalanalogclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;

public class MainActivity extends AppCompatActivity {
    private static Button buttonSbmt;
    private static AnalogClock analogClock;
    private static DigitalClock digitalClock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClick();
    }

    public void onButtonClick(){
        buttonSbmt = (Button)findViewById(R.id.button);
        analogClock = (AnalogClock)findViewById(R.id.analogClock);
        digitalClock = (DigitalClock)findViewById(R.id.digitalClock);

        buttonSbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (digitalClock.getVisibility()==DigitalClock.GONE){
                    digitalClock.setVisibility(DigitalClock.VISIBLE);
                    analogClock.setVisibility(AnalogClock.GONE);
                }else {
                    digitalClock.setVisibility(DigitalClock.GONE);
                    analogClock.setVisibility(AnalogClock.VISIBLE);
                }

            }
        });
    }
}
