package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewAccount extends AppCompatActivity {
    TextView ed1,ed2,ed3,ed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_account);

        ed1 = (TextView) findViewById(R.id.dynamic_user_account);
        ed2 = (TextView) findViewById(R.id.bank_bal);
        ed3 = (TextView) findViewById(R.id.upi_bal);
        ed4 = (TextView) findViewById(R.id.cash_bal);

        ed1.setText("Hello, " + User.user_name);
        ed2.setText(Integer.toString(Account.bank_balance));
        ed3.setText(Integer.toString(Account.upi_balance));
        ed4.setText(Integer.toString(Account.cash_balance));

    }

    public void nav_dash(View v)
    {

    }

    public void nav_home(View v)
    {
        Intent nav_home = new Intent(getApplicationContext(),home_screen.class);
        startActivity(nav_home);

    }

    public void nav_profile(View v)
    {
        Intent intent_profile = new Intent(getBaseContext(),Profile.class);
        startActivity(intent_profile);

    }

    public void nav_expense(View v)
    {
        Intent nav_expense = new Intent(getApplicationContext(),Expense.class);
        startActivity(nav_expense);

    }
}