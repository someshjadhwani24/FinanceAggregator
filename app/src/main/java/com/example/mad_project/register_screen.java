package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class register_screen extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
    }

    public void register(View v)
    {
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.email);
        ed3=(EditText) findViewById(R.id.password);
        ed4=(EditText) findViewById(R.id.re_password);

        String name= String.valueOf(ed1.getText());
        String email= String.valueOf(ed2.getText());
        String password= String.valueOf(ed3.getText());
        String re_password= String.valueOf(ed4.getText());


        if(password==re_password)
        {

        }

    }

}