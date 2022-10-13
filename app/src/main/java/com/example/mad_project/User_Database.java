package com.example.mad_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class User_Database extends SQLiteOpenHelper {
    public User_Database(Context context) {
        super(context, "master.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(user_id int primary key, user_name TEXT,user_email TEXT,user_password TEXT,user_total_balance int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");

    }

    public boolean insertuserdata(long id,String name,String email,String password,long total_balance)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues user=new ContentValues();
        user.put("user_id",id);
        user.put("user_name",name);
        user.put("user_email",email);
        user.put("user_password",password);
      //  user.put("logged_in",log_in);
        user.put("user_total_balance",total_balance);


        long result=db.insert("users",null,user);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }


    }

    public boolean updateuserdata(long id,String name,String email,String password,Boolean log_in,long total_balance)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues user=new ContentValues();
        user.put("user_id",id);
        user.put("user_name",name);
        user.put("user_email",email);
        user.put("user_password",password);
        user.put("logged_in",log_in);
        user.put("user_total_balance",total_balance);
        Cursor c=db.rawQuery("Select * from users where id=?",new String[]{String.valueOf(id)});
        if(c.getCount()>0)
        {
            long result=db.update("users",user,"id=?",new String[] {String.valueOf(id)});
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

    public Cursor viewuseremail(String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from users where user_email='"+email +"'";
        Cursor c=db.rawQuery(query, null);
        return c;
    }

    public Cursor viewuserpassword(String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select user_password from users where user_email="+email;
        Cursor c=db.rawQuery(query, null);
        return c;
    }

    public Cursor viewuserid()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("Select * from users", null);
        return c;
    }

}
