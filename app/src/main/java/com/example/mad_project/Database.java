package com.example.mad_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database( Context context) {
        super(context, "test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table test(user_id int primary key, user_name TEXT,user_email TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists test");

    }

    public boolean insertuserdata(long id,String name,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues user1=new ContentValues();
        user1.put("user_id",id);
        user1.put("user_name",name);
        user1.put("user_email",email);
        long result=db.insert("test",null,user1);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }


    }

    public boolean updateuserdata(long id,String name,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues user1=new ContentValues();
        user1.put("user_name",name);
        user1.put("user_email",email);
        Cursor c=db.rawQuery("Select * from test where id=?",new String[]{String.valueOf(id)});
        if(c.getCount()>0)
        {
            long result=db.update("test",user1,"id=?",new String[] {String.valueOf(id)});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    public Cursor viewuserdata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("Select * from test", null);
        return c;
    }



}
