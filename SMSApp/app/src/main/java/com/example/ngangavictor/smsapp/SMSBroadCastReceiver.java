package com.example.ngangavictor.smsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SMSBroadCastReceiver extends BroadcastReceiver {

    public static final String SMS_BUNDLE = "pdus";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();

        if (intentExtras != null){
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            String smsMessageStr = "";

            for (int i=0; i<sms.length;i++){
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])sms[i]);
                String smsBody = smsMessage.getMessageBody().toString();
                String address = smsMessage.getOriginatingAddress();
                long timeMillis = smsMessage.getTimestampMillis();

                Date date = new Date(timeMillis);
                SimpleDateFormat format =  new SimpleDateFormat("dd/MM/yy");
                String dateText = format.format(date);

                smsMessageStr += address + " at " + "\t" + dateText + "\n";
                smsMessageStr += smsBody + "\n";
            }
            Toast.makeText(context, smsMessageStr,Toast.LENGTH_LONG).show();

            ActivityReceiveSMS inst = ActivityReceiveSMS.instance();
            if (inst != null){
                inst.updateList(smsMessageStr);
            }
        }
    }
}
