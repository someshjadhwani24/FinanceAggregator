package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.register_main);
        b2 = (Button) findViewById(R.id.sign_in);

        Database db=new Database(this);
        long id=7048;
        String name="abc";
        String email="abc@gmail.com";
        Boolean checki=db.insertuserdata(id,name,email);
        System.out.println(checki);
        Cursor res=db.viewuserdata();
        if(res.getCount()==0)
        {
            System.out.println("No data");
        }
        StringBuffer b=new StringBuffer();
        while(res.moveToNext())
        {
            b.append("Id:- "+res.getString(0)+"\n");
            b.append("Name:- "+res.getString(1)+"\n");
            b.append("Email:- "+res.getString(2)+"\n");
        }
        System.out.println(b);
    }


    public void register_2(View v)
    {
        Intent intent2 = new Intent(getApplicationContext(),register_screen.class);
        startActivity(intent2);
    }


    public void signin_main(View v)
    {
        Intent obj=new Intent(MainActivity.this, Login.class);
        startActivity(obj);
    }
}