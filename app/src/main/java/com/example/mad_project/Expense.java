package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Expense extends AppCompatActivity {
    TextView ed5,ed6;
    EditText ed1,ed2,ed3;
    int account_pick =1;
    Button bank,upi,cash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        TextView user_exp = (TextView) findViewById(R.id.dynamic_user_expense);
        ed5=(TextView) findViewById(R.id.date);
        ed6 = (TextView) findViewById(R.id.dynamic_amt);

        user_exp.setText("Hello" + User.user_name);


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sdf.format(cal.getTime());
        System.out.println(strDate);

        ed5.setText(strDate);
        Transaction.date = strDate;

        String total_bal = Integer.toString(User.total_balance);
        System.out.println(total_bal);
        ed6.setText("INR" + total_bal);

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

    public void record_expense(View v)
    {
        ed1=(EditText) findViewById(R.id.amount);
        ed2=(EditText) findViewById(R.id.enter_category);
        ed3=(EditText) findViewById(R.id.desc);
        int amount;

        String amt_value = String.valueOf(ed1.getText());
        if(amt_value.length() > 0)
        {
            amount = Integer.parseInt(amt_value);
        }
        else
        {
            amount = 0;
        }
        String desc= String.valueOf(ed3.getText());
        String category=String.valueOf(ed2.getText());

        Intent record_obj = new Intent(getApplicationContext(),home_screen.class);


        User.total_balance = User.total_balance - amount ;
        Transaction.amount = amount;
        Transaction.account = account_pick;
        Transaction.category = category;
        Transaction.desc = desc;
        Account a1 = new Account();
        a1.expense(account_pick,amount);

        System.out.println(Account.bank_balance);
        System.out.println(Account.upi_balance);
        System.out.println(Account.cash_balance);

        if(User.total_balance < 1)
        {
            Toast.makeText(getApplicationContext(),"Your total balance has gone into negative",Toast.LENGTH_LONG).show();

        }

        if(amt_value.length() < 1)
        {
            Toast.makeText(getApplicationContext(),"Amount Cant be empty",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Expense recorded",Toast.LENGTH_LONG).show();
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

    public void nav_income(View v)
    {
        Intent nav_income = new Intent(getApplicationContext(),Income.class);
        startActivity(nav_income);

    }


}