package com.example.ngangavictor.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Datus";
    public static final String TABLE_NAME = "tbl_details";
    public static final String COL_1 = "fname";
    public static final String COL_2 = "sname";
    public static final String COL_3 = "email";
    public static final String COL_4 = "phone";
    public static final String COL_5 = "location";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (fname TEXT,sname TEXT,email TEXT,phone INTEGER,location TEXT ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname,String sname,String email,String phone,String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,fname);
        contentValues.put(COL_2,sname);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,phone);
        contentValues.put(COL_5,location);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }

    }
}
