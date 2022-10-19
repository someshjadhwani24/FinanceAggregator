package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    int account_pick =1;
    EditText ed1;
    Button bank,upi,cash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        TextView user = (TextView) findViewById(R.id.dynamic_user_addacc);
        user.setText("Hello " + User.user_name);

        bank = (Button) findViewById(R.id.bank);
        upi = (Button) findViewById(R.id.upi);
        cash = (Button) findViewById(R.id.Cash);
    }

    public void bank(View v)
    {
        account_pick =1;
        cash.setAlpha(0.6f);
        upi.setAlpha(0.6f);
        bank.setAlpha(1.0f);


    }

    public void upi(View v)
    {
        account_pick =2;
        cash.setAlpha(0.6f);
        upi.setAlpha(1f);
        bank.setAlpha(0.6f);

    }

    public void cash(View v)
    {
        account_pick =3;
        cash.setAlpha(1f);
        upi.setAlpha(0.6f);
        bank.setAlpha(0.6f);

    }

    public void addac(View v)
    {
        int amount;
        ed1=(EditText) findViewById(R.id.enter_bal);

        String amt_value = String.valueOf(ed1.getText());
        if(amt_value.length() > 1)
        {
            amount = Integer.parseInt(amt_value);
        }
        else
        {
            amount = 0;
        }

        User.total_balance = User.total_balance + amount ;
        Account a1 = new Account();
        a1.income(account_pick,amount);

        Intent record_obj = new Intent(getApplicationContext(),home_screen.class);

        if(amt_value.length() < 1)
        {
            Toast.makeText(getApplicationContext(),"Opening Balance Cant be empty",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Account Added",Toast.LENGTH_LONG).show();
            startActivity(record_obj);
        }

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

    public void nav_income(View v)
    {
        Intent nav_income = new Intent(getApplicationContext(),Income.class);
        startActivity(nav_income);

    }
}