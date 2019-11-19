package com.example.ngangavictor.cartsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version ) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(int id,String name,String price,String quantity){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "INSERT INTO product VALUES (?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double) id);
        statement.bindString(2,name);
        statement.bindString(3,price);
        statement.bindString(4,quantity);
        statement.executeInsert();
    }

    public void deleteData(int id){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM product WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double)id);
        statement.execute();
        database.close();
    }

    public String countData(){
    SQLiteDatabase database = getWritableDatabase();
    String sql = "SELECT COUNT(*) FROM product";
   // long count = DatabaseUtils.queryNumEntries(database,"product");
    Cursor cursor = database.rawQuery(sql,null);
    cursor.moveToFirst();
    String count = cursor.getString(0);
    //int count = cursor.getCount();
    //cursor.close();
        database.close();
    return count;
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(sql,null);
    }



}
