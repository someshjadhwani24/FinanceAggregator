package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View v)
    {
        Intent obj1=new Intent(MainActivity.this,register_screen.class);
        startActivity(obj1);
    }

    public void sign_up(View v)
    {
        Intent obj=new Intent(MainActivity.this,login.class);
        startActivity(obj);
    }


}