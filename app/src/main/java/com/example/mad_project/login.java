package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {

    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void sign_up(View v)
    {
        Intent obj=new Intent(login.this,register_screen.class);
        startActivity(obj);
    }

    public void login(View v)
    {
        ed1=(EditText) findViewById(R.id.enter_email);
        ed2=(EditText) findViewById(R.id.enter_password);

        String email= String.valueOf(ed1.getText());
        String password=String.valueOf(ed2.getText());

        String db_password = "admin";
        if(password==db_password)
        {
            Intent obj=new Intent(login.this,home_screen.class);
            startActivity(obj);

        }


    }

}