package com.example.ngangavictor.androidpay.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngangavictor.androidpay.R;
import com.example.ngangavictor.androidpay.entities.ProductObject;
import com.example.ngangavictor.androidpay.helpers.MySharedPreference;

import java.util.List;

public class CheckRecyclerViewAdapter extends RecyclerView.Adapter<CheckRecyclerViewHolder> {
    private Context context;
    private List<ProductObject> mProductObject;
    private MySharedPreference sharedPreference;

    public CheckRecyclerViewAdapter(Context context, List<ProductObject> mProductObject) {
        this.context = context;
        this.mProductObject = mProductObject;
    }
    @Override
    public CheckRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_layout, parent, false);
        CheckRecyclerViewHolder productHolder = new CheckRecyclerViewHolder(layoutView);
        return productHolder;
    }
    @Override
    public void onBindViewHolder(CheckRecyclerViewHolder holder, final int position) {
        //get product quantity
        holder.quantity.setText("1");
        holder.productName.setText(mProductObject.get(position).getProductName());
        holder.productPrice.setText(String.valueOf(mProductObject.get(position).getProductPrice()) + " $");
        /*holder.removeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MySharedPreference mySharedPreference = new MySharedPreference(context);
                sharedPreference = new MySharedPreference(context);
                //sharedPreference.removeProductFromCart();
                //sharedPreference.removeProductFromCart(String.valueOf(mProductObject.get(position).getProductId()));
                Toast.makeText(context, "Do you want to remove product from cart", Toast.LENGTH_LONG).show();
            }
        });*/
        holder.removeProduct.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                sharedPreference = new MySharedPreference(context);
                sharedPreference.removeProductFromCart(String.valueOf(mProductObject.get(position).getProductId()));
                return true;
            }
        });
    }
    @Override
    public int getItemCount() {
        return mProductObject.size();
    }
}
