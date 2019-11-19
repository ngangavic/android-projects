package com.example.ngangavictor.smsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySendSMS extends AppCompatActivity {

    Button sendSmsBtn;
    EditText toPhoneNumber;
    EditText smsMessageEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_send_sms);

        sendSmsBtn = (Button)findViewById(R.id.buttonSend);
        toPhoneNumber = (EditText)findViewById(R.id.editTextPhone);
        smsMessageEt = (EditText)findViewById(R.id.editTextMessage);

        sendSmsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms();
            }
        });
    }

    private void sendSms() {
        String toPhone = toPhoneNumber.getText().toString();
        String smsMessage = smsMessageEt.getText().toString();

        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(toPhone,null,smsMessage,null,null);
            Toast.makeText(this,"SMS Manager",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void goToInbox(View view){
        Intent intent = new Intent(ActivitySendSMS.this,ActivityReceiveSMS.class);
        startActivity(intent);
    }
}
