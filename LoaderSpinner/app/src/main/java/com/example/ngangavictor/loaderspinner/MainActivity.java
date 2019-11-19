package com.example.ngangavictor.loaderspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> spinnerAdapterData = new ArrayList<>();
        //String[] spinnerItemsArray = getResources().getStringArray(R.array.items);
        Collections.addAll(spinnerAdapterData);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.custom_spinner, spinnerAdapterData, getResources());

        Spinner itemList = (Spinner) findViewById(R.id.spinner);
        itemList.setAdapter(adapter);

        itemList.setOnItemSelectedListener(MainActivity.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
