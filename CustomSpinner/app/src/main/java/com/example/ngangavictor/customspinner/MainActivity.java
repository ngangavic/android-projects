package com.example.ngangavictor.customspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Boolean mAllowSelectionFiring = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> spinnerAdapterData = new ArrayList<>();
        String[] spinnerItemsArray = getResources().getStringArray(R.array.items);
        Collections.addAll(spinnerAdapterData, spinnerItemsArray);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.adapter_spinner, spinnerAdapterData, getResources());

        Spinner itemList = (Spinner) findViewById(R.id.spinner);
        itemList.setAdapter(adapter);

        itemList.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (mAllowSelectionFiring) {
            int selectedItemPosition = Integer.parseInt(view.getTag(R.string.meta_position).toString().trim());
            String selectedItemTitle = view.getTag(R.string.meta_title).toString().trim();

            Toast.makeText(getApplicationContext(), selectedItemPosition + ". " + selectedItemTitle, Toast.LENGTH_LONG).show();
        } else {
            mAllowSelectionFiring = true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
