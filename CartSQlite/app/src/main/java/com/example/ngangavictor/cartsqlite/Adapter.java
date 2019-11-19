package com.example.ngangavictor.cartsqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private int Layout;
    private ArrayList<Model> cartList;

    public Adapter(Context context, int layout, ArrayList<Model> cartList) {
        this.context = context;
        Layout = layout;
        this.cartList = cartList;
    }

    @Override
    public int getCount() {
        return cartList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView txtId,txtName,txtPrice,txtQuantity;
        Button delete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row==null){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(Layout,null);
            //row = inflater.inflate(Layout,parent,false);
           holder.txtId = row.findViewById(R.id.txtId);
           holder.txtName = row.findViewById(R.id.txtName);
           holder.txtPrice = row.findViewById(R.id.txtPrice);
           holder.txtQuantity = row.findViewById(R.id.txtQuantity);
            holder.delete = row.findViewById(R.id.btnDelete);
           row.setTag(holder);
       }else {
            holder = (ViewHolder)row.getTag();
        }

        final Model model  = cartList.get(position);

        holder.txtId.setText(model.getId());
        holder.txtName.setText(model.getName());
        holder.txtPrice.setText(model.getPrice());
        holder.txtQuantity.setText(model.getQuantity());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(model.getId());
                //Toast.makeText(this,model.getId(),Toast.LENGTH_LONG).show();
                MainActivity.dbHelper.deleteData(Integer.parseInt(model.getId()));
                ((Activity)context).finish();
                Intent intent = new Intent(context,ViewActivity.class);
                context.startActivity(intent);
            }
        });

        return row;
    }
}
