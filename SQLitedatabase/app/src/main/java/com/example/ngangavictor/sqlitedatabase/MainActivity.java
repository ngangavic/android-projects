package com.example.ngangavictor.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private EditText etFname,etSname,etEmail,etPhone,etLocation;
    private Button button;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        etFname =(EditText)findViewById(R.id.editTextFname);
        etSname =(EditText)findViewById(R.id.editTextSname);
        etEmail =(EditText)findViewById(R.id.editTextEmail);
        etPhone =(EditText)findViewById(R.id.editTextPhone);
        etLocation =(EditText)findViewById(R.id.editTextLocation);
        button =(Button)findViewById(R.id.buttonSave);
        onButtonclick();
    }

    public void onButtonclick(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertData(
                        etFname.getText().toString(),
                        etSname.getText().toString(),
                        etEmail.getText().toString(),
                        etPhone.getText().toString(),
                        etLocation.getText().toString());
                if (isInserted==true){
                    clearTextFields();
                    Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
                }else {
                    clearTextFields();
                    Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void clearTextFields(){
        etFname.getText().clear();
        etSname.getText().clear();
        etEmail.getText().clear();
        etPhone.getText().clear();
        etLocation.getText().clear();
    }
}
