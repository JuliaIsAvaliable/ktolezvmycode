package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.LinkedList;

public class DBhelper extends SQLiteOpenHelper {

    private static final String USER = "user";
    private static final String COLUMN_LOGIN = "COLUMN_LOGIN";
    private static final String COLUMN_PASSWORD = "COLUMN_PASSWORD";

    public DBhelper(@Nullable Context context) {
        super(context, "example.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + USER + " ("+COLUMN_LOGIN+" TEXT, "+COLUMN_PASSWORD+" INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void DeleteOne(String  lo){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ USER +" WHERE "+COLUMN_LOGIN+" = "+"'"+lo+"'");
        db.close();
    }

    public void Update(String  lo,String pa){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+ USER +" SET "+COLUMN_PASSWORD+ "= '"+ pa +"'  WHERE "+COLUMN_LOGIN+" = "+"'"+lo+"'");
        db.close();
    }

    public void Select(String  lo){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("SELECT "+COLUMN_PASSWORD+ " FROM "+ USER +" WHERE "+COLUMN_LOGIN+" = "+"'"+lo+"'");

        db.close();
    }


    public void AddOne (Data data){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_LOGIN,data.Login);
        cv.put(COLUMN_PASSWORD,data.Password);
        sqLiteDatabase.insert(USER, null,cv);
        sqLiteDatabase.close();
    }


}
