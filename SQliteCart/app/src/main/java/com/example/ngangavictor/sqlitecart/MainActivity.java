package com.example.ngangavictor.sqlitecart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextId,mEditTextName,mEditTextPrice,mEditTextQuantity;
    private Button mButtonCart,mButtonView;
    private DbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextId = (EditText)findViewById(R.id.editTextId);
        mEditTextName = (EditText)findViewById(R.id.editTextName);
        mEditTextPrice = (EditText)findViewById(R.id.editTextPrice);
        mEditTextQuantity = (EditText)findViewById(R.id.editTextQuantity);
        mButtonCart = (Button)findViewById(R.id.buttonAddCart);
        mButtonView = (Button)findViewById(R.id.buttonView);

        myDb = new DbHelper(this);
        mButtonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickInsert();
                clearTextFields();
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

    private void OnClickInsert(){
        myDb.insertProduct(mEditTextName.getText().toString(),mEditTextPrice.getText().toString(),mEditTextQuantity.getText().toString());
    }

    private void clearTextFields(){
        mEditTextId.getText().clear();
        mEditTextName.getText().clear();
        mEditTextPrice.getText().clear();
        mEditTextQuantity.getText().clear();
    }
}
