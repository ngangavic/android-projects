package com.example.ngangavictor.smsapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityReceiveSMS extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static ActivityReceiveSMS inst;
    ArrayList<String> smsMessageList = new ArrayList<String>();
    ListView smsListView;
    ArrayAdapter arrayAdapter;

    public static ActivityReceiveSMS instance(){
        return inst;
    }

    @Override
    protected void onStart() {
        super.onStart();
        inst=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_receive_sms);

        smsListView = (ListView)findViewById(R.id.SMSList);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,smsMessageList);
        smsListView.setAdapter(arrayAdapter);
        smsListView.setOnItemClickListener(this);

        refreshSmsInbox();
    }

    private void refreshSmsInbox() {
        ContentResolver contentResolver = getContentResolver();
        Cursor smsInboxCursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");
        int timeMillis = smsInboxCursor.getColumnIndex("date");
        Date date = new Date(timeMillis);
        SimpleDateFormat format =  new SimpleDateFormat("dd/MM/yy");
        String dateText = format.format(date);

        if (indexBody <0 || !smsInboxCursor.moveToFirst())return;
        arrayAdapter.clear();

        do {

            String str = smsInboxCursor.getString(indexAddress) + " at " + "\n" + smsInboxCursor.getString(indexBody)+ dateText + "\n";
            arrayAdapter.add(str);
        }while (smsInboxCursor.moveToNext());

    }

    public void updateList(final String smsMessage){
        arrayAdapter.insert(smsMessage,0);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try{

            String[] smsMessages = smsMessageList.get(position).split("\n");
            String address = smsMessages[0];
            String smsMessage = "";

            for (int i=1;i < smsMessages.length;i++){
                smsMessage += smsMessages[i];
            }

            String smsMesageStr =address + "\n";
            smsMesageStr += smsMessage;
            Toast.makeText(this,smsMesageStr,Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void goToCompose(View view){
        Intent intent = new Intent(ActivityReceiveSMS.this,ActivitySendSMS.class);
        startActivity(intent);
    }
}
