package com.example.ldtwapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Users(username Text primary key, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists Users");
    }


    public Boolean insertData (String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=MyDB.insert("Users",null,contentValues);

        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor =MyDB.rawQuery("select * from Users", null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            if(cursor.getString(0) == username){
                return true;
            }
            cursor.moveToNext();
        }
        return false;
    }
    public Boolean checkUsernamePassword(String username,String pass){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from Users", null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            System.out.println(cursor.getString(0) + " "+ cursor.getString(1));
            if(cursor.getString(0).equals(username) && cursor.getString(1).equals(pass)){
                System.out.println("Done");
                return true;
            }
            cursor.moveToNext();
        }
        return false;
    }
}
