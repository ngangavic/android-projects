package com.example.ngangavictor.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sreen1 extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sreen1);
        TextView showCartContent = (TextView)findViewById(R.id.showcart);
        final Button btn3 = (Button)findViewById(R.id.third);
        final Controller ct = (Controller)getApplicationContext();
        final int CartSize = ct.getCart().getCartsize();
        String show = "";
        if(CartSize >0){
            for(int i=0;i<CartSize;i++){
                String pName = ct.getCart().getProducts(i).getProductName();
                int  pPrice = ct.getCart().getProducts(i).getProductPrice();
                String pDisc = ct.getCart().getProducts(i).getProductDesc();
                show += "Product Name:"+pName+" "+"Price : "+pPrice+""+"Discription : "+pDisc+""+
                        "-----------------------------------";
            }
        } else{
            show = "There is no Items in Shopping Cart";
        showCartContent.setText(show);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(CartSize >0){
                        Intent i = new Intent(getBaseContext(),Screen2.class);
                        startActivity(i);
                    }else {

                        Toast.makeText(getApplicationContext(), "Shopping Cart is Empty", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
}

