package com.example.ngangavictor.cartsqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    ListView mListView;
    ArrayList<Model> mList;
    Adapter mAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mListView = findViewById(R.id.listview);
        mList = new ArrayList<>();
        mAdapter = new Adapter(this,R.layout.view_layout_data,mList);
        mListView.setAdapter(mAdapter);

        Cursor cursor = MainActivity.dbHelper.getData("SELECT * FROM product");
        mList.clear();
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String quantity = cursor.getString(3);
            mList.add(new Model(id,name,price,quantity));
        }
        mAdapter.notifyDataSetChanged();
        if (mList.size()==0){
            Toast.makeText(this,"Cart is Empty",Toast.LENGTH_LONG).show();
        }


    }
}
