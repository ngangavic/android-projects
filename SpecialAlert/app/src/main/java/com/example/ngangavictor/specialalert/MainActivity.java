package com.example.ngangavictor.specialalert;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertSpecial();
            }
        });
    }


    private void alertSpecial(){
        ProgressBar p = new ProgressBar(this);
       AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alertDialogBuilder.setView(R.layout.alert);
        }else {
            alertDialogBuilder.setView(p);
            alertDialogBuilder.setMessage("Verifying Code");
        }
        /*alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You clicked YES", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You clicked NO", Toast.LENGTH_SHORT).show();
            }
        });*/
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
