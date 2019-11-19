package com.example.ngangavictor.cart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        TextView showCartContent = (TextView)findViewById(R.id.showcart);
        final Controller ct = (Controller)getApplicationContext();
        final int CartSize = ct.getCart().getCartsize();
        String show = "";
        for(int i=0;i<CartSize;i++){
            String pName = ct.getCart().getProducts(i).getProductName();
            int  pPrice = ct.getCart().getProducts(i).getProductPrice();
            String pDisc = ct.getCart().getProducts(i).getProductDesc();
            show += "Product Name:"+pName+" "+"Price : "+pPrice+""+"Discription : "+pDisc+""+    "-----------------------------------";
        }
        showCartContent.setText(show);
    }
}
