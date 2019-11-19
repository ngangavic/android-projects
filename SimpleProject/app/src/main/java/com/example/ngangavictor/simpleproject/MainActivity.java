package com.example.ngangavictor.simpleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButton();
    }

    public void onClickButton(){
        etEmail = (EditText)findViewById(R.id.editTextEmail);
        etPassword = (EditText)findViewById(R.id.editTextPassword);
        button = (Button)findViewById(R.id.buttonLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((etEmail.getText().toString().equals("needle@gmail.com")) && (etPassword.getText().toString().equals("kasuku"))) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                    clearTextFields();
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                    clearTextFields();
                }

            }
        });
    }

    public void clearTextFields(){
        etEmail = (EditText)findViewById(R.id.editTextEmail);
        etPassword = (EditText)findViewById(R.id.editTextPassword);
        //button = (Button)findViewById(R.id.buttonLogin);

        etEmail.getText().clear();
        etPassword.getText().clear();

    }
}
