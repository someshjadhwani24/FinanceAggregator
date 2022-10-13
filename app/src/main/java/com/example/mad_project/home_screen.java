package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class home_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String str;
        setContentView(R.layout.activity_home_screen);
        TextView user = (TextView) findViewById(R.id.dynamic_user);

        System.out.println("The current user is " + User.user_name);

        user.setText(User.user_name);
    }
}