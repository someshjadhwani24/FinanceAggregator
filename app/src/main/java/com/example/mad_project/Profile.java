package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {

    TextView ed1,ed2,ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ed1 = (TextView) findViewById(R.id.dynamic_user);
        ed2 = (TextView) findViewById(R.id.dynamic_bal);
        ed3 = (TextView) findViewById(R.id.dynamic_email);

        ed1.setText(User.user_name);
        ed3.setText(User.email);
        ed2.setText("INR " + User.total_balance);
    }



    public void nav_dash(View v)
    {

    }

    public void nav_home(View v)
    {
        Intent nav_home = new Intent(getApplicationContext(),home_screen.class);
        startActivity(nav_home);

    }

    public void nav_income(View v)
    {
        Intent nav_income = new Intent(getApplicationContext(),Income.class);
        startActivity(nav_income);

    }

    public void nav_expense(View v)
    {
        Intent nav_expense = new Intent(getApplicationContext(),Expense.class);
        startActivity(nav_expense);

    }

    public void view_acc(View v)
    {
        Intent nav_acc = new Intent(getApplicationContext(),ViewAccount.class);
        startActivity(nav_acc);

    }

    public void add_acc(View v)
    {
        Intent nav_acc = new Intent(getApplicationContext(),CreateAccount.class);
        startActivity(nav_acc);

    }
}