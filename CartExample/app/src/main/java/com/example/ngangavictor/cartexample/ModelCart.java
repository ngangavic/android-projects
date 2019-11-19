package com.example.ngangavictor.cartexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ModelCart {

    private ArrayList<ModelProducts> cartItems = new ArrayList<ModelProducts>();
    public ModelProducts getProducts(int position){
        return cartItems.get(position);
    }
    public void setProducts(ModelProducts Products){
        cartItems.add(Products);
    }
    public int getCartsize(){

        return cartItems.size();
    }
    public boolean CheckProductInCart(ModelProducts aproduct){
        return cartItems.contains(aproduct);
    }
}
