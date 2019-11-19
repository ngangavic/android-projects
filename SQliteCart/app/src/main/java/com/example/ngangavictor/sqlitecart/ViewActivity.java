package com.example.ngangavictor.sqlitecart;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    DbHelper dbHelper;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        dbHelper = new DbHelper(this);
        arrayList = new ArrayList<>();
        listView = findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                deleteProduct(listView.getId());
                Toast.makeText(ViewActivity.this,String.valueOf(listView.getId()),Toast.LENGTH_LONG).show();
            }
        });

        //LISTVIEW = (ListView) findViewById(R.id.listview);
        displayListView();
    }

    private void displayListView() {
        Cursor cursor = dbHelper.getData();
        if (cursor.getCount()==0){
            Toast.makeText(ViewActivity.this,"No data",Toast.LENGTH_LONG).show();
        }else {
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(cursor.getColumnIndex(DbHelper.CART_COLUMN_ID)));
                arrayList.add(cursor.getString(cursor.getColumnIndex(DbHelper.CART_COLUMN_NAME)));
                arrayList.add(cursor.getString(cursor.getColumnIndex(DbHelper.CART_COLUMN_PRICE)));
                arrayList.add(cursor.getString(cursor.getColumnIndex(DbHelper.CART_COLUMN_QUANTITY)));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(arrayAdapter);
            }
        }

    }

    private void deleteProduct(int id){
        dbHelper.deleteProduct(id);
    }



}
