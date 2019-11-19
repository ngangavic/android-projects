package com.example.ngangavictor.sqlitecart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyCart.db";
    public static final String CART_TABLE_NAME = "tbl_cart";
    public static final String CART_COLUMN_ID = "id";
    public static final String CART_COLUMN_NAME = "name";
    public static final String CART_COLUMN_PRICE = "price";
    public static final String CART_COLUMN_QUANTITY = "quantity";
    private HashMap hp;


    public DbHelper( Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table tbl_cart (id integer primary key autoincrement, name text,price text,quantity text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_cart");
        onCreate(db);
    }

    public boolean insertProduct(String name,String price,String quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("price", price);
        contentValues.put("quantity", quantity);
        db.insert(DbHelper.CART_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from tbl_cart",null );
        return cursor;
    }

    public Integer deleteProduct (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("tbl_cart",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

   /* public ArrayList<String> getAllProducts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tbl_cart", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CART_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }*/
}
