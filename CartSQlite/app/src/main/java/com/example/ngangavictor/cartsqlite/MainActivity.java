package com.example.ngangavictor.cartsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEditTextId,mEditTextName,mEditTextPrice,mEditTextQuantity;
    Button mButtonAdd,mButtonView,mButtonC;

    public static DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextId = findViewById(R.id.editTextId);
        mEditTextName = findViewById(R.id.editTextName);
        mEditTextPrice = findViewById(R.id.editTextPrice);
        mEditTextQuantity = findViewById(R.id.editTextQuantity);
        mButtonAdd = findViewById(R.id.buttonAdd);
        mButtonView = findViewById(R.id.buttonView);
        mButtonC = findViewById(R.id.buttonC);

       // String cartCount = dbHelper.countData();
        //mButtonC.setText(cartCount);

        dbHelper = new DbHelper(this,"CART.sqlite",null,1);
        dbHelper.queryData("CREATE TABLE IF NOT EXISTS product (id INTEGER PRIMARY KEY,name VARCHAR,price VARCHAR,quantity VARCHAR)");

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    dbHelper.insertData(
                            Integer.parseInt(mEditTextId.getText().toString().trim()),
                            mEditTextName.getText().toString().trim(),
                            mEditTextPrice.getText().toString().trim(),
                            mEditTextQuantity.getText().toString().trim()
                    );
                    //MainActivity.finish();
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                    clearTextFields();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        mButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewActivity.class);
                 startActivity(intent);
            }
        });


    }

    private void clearTextFields(){
        mEditTextId.getText().clear();
        mEditTextName.getText().clear();
        mEditTextPrice.getText().clear();
        mEditTextQuantity.getText().clear();
    }

}
