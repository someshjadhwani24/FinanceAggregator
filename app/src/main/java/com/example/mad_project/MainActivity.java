package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    }
    /*
    public void register_main(View v)
    {
        Intent obj1=new Intent(MainActivity.this,home_screen.class);
        startActivity(obj1);
    }

     */

    public void register_2(View v)
    {
        Intent intent2 = new Intent(getApplicationContext(),register_screen.class);
        startActivity(intent2);
    }


    public void signin_main(View v)
    {
        Intent obj=new Intent(MainActivity.this,login.class);
        startActivity(obj);
    }
}