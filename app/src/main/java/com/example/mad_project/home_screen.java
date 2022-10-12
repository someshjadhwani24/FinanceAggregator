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

        Intent intent = getIntent();
        str = intent.getStringExtra("message_key");
        str = intent.getStringExtra("Message_key2");
        user.setText(str);
    }
}