package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;

public class BDhelp extends SQLiteOpenHelper{
    public static final String USER = "user";
    public static final String ID = "id";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    public BDhelp(@Nullable Context context)
    {
        super(context, USER + "s.bd", null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + USER + " (" + ID + " Integer, " + LOGIN + " Text, " + PASSWORD + " Text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Add(String email, String password)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT into user('Login','password') Values (?,?)", new Object[]{LOGIN, PASSWORD});
    }
}
