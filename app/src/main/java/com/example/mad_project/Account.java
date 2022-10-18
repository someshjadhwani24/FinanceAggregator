package com.example.mad_project;

public class Account {

    public static int bank_balance;
    public static int upi_balance;
    public static int cash_balance;
    public static int bank_nickname;
    public static int upi_nickname;
    public static int cash_nickname;

    public void income(int acc_no,int amt)
    {
        if (acc_no == 1)
        {
            bank_balance = bank_balance + amt;
        }
        else if (acc_no == 2)
        {
            upi_balance = upi_balance + amt;
        }
        else if (acc_no == 3)
        {
            cash_balance = cash_balance + amt;
        }
    }

    public void expense(int acc_no,int amt)
    {
        if (acc_no == 1)
        {
            bank_balance = bank_balance - amt;
        }
        else if (acc_no == 2)
        {
            upi_balance = upi_balance - amt;
        }
        else if (acc_no == 3)
        {
            cash_balance = cash_balance - amt;
        }
    }
}
