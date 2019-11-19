package com.example.ngangavictor.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText usename,password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usename = (EditText)findViewById(R.id.etUname);
        password = (EditText)findViewById(R.id.etPassword);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usename.getText().toString().equals("Vic")&&password.getText().toString().equals("0000")){
                    /*Intent intent = new Intent(MainActivity.this,NextActivity.class);
                    intent.putExtra("user_name",usename.getText().toString());
                    startActivityForResult(intent, 1);*/
                    Intent myintent=new Intent(MainActivity.this, NextActivity.class).putExtra("user_name", usename.getText().toString());
                    startActivity(myintent);
                }else {
                    Toast.makeText(MainActivity.this,"You entered the wrong ctredential",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /*public void buttonLogin(View view){
        if (usename.getText().toString().equals("Vic")&&password.getText().toString().equals("0000")){
            Intent intent = new Intent(MainActivity.this,NextActivity.class);
            intent.putExtra("user_name",usename.getText().toString());
            startActivityForResult(intent,1);
        }else {
            Toast.makeText(MainActivity.this,"You entered the wrong ctredential",Toast.LENGTH_LONG).show();
        }
    }*/
}
