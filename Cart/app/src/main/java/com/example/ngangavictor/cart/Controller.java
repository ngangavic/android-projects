package com.example.ngangavictor.cart;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {

    private ArrayList<ModelProducts> myproducts = new ArrayList<ModelProducts>();
    private ModelCart myCart = new ModelCart();
    public ModelProducts getProducts(int pPosition){
        return myproducts.get(pPosition);
    }
    public void  setProducts(ModelProducts products){
        myproducts.add(products);
    }
    public ModelCart getCart(){
        return myCart;
    }
    public int  getProductArraylistsize(){
        return myproducts.size();
    }
}
