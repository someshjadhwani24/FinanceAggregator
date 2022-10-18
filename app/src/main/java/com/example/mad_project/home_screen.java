package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public void logout(View v)
    {
        Toast.makeText(getApplicationContext(),"Logging Out",Toast.LENGTH_LONG).show();
        Intent intent_logout = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent_logout);
    }

    public void income(View v)
    {
        Intent intent_income = new Intent(getBaseContext(),Income.class);
        startActivity(intent_income);
        System.out.println("Home Screen intent works");
    }

    public void expense(View v)
    {
        Intent intent_expense = new Intent(getBaseContext(),Expense.class);
        startActivity(intent_expense);
        System.out.println("Home Screen intent works");
    }

    public void profile(View v)
    {
        Intent intent_profile = new Intent(getBaseContext(),Profile.class);
        startActivity(intent_profile);

    }
}