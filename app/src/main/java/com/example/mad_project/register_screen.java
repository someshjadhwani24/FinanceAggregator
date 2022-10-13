package com.example.mad_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class register_screen extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    String name;
    String email;
    String password;
    String re_password;


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

        name= String.valueOf(ed1.getText());
        email= String.valueOf(ed2.getText());
        password= String.valueOf(ed3.getText());
        re_password= String.valueOf(ed4.getText());
        long user_id;

        validation obj1=new validation();
        boolean e_val=obj1.emailvalidate(email);
        boolean p_val=obj1.passwordvalidate(password,password);
        boolean r_val = password.equals(re_password);

        if(e_val && p_val && r_val)
        {
            user_id=new Random().nextInt(900000)+100000;

            User.user_name=name;
            User.user_id = user_id;
            User.logged_in = true;
            User.email = email;
            User.password = password;
            User.total_balance=0;



            User_Database db=new User_Database(this);

            Boolean checki=db.insertuserdata(user_id,name,email,password,User.total_balance);
            System.out.println("Did it work" + checki);

            Intent obj=new Intent(register_screen.this,home_screen.class);
            startActivity(obj);
        }
        else if(e_val == false)
        {
            Toast.makeText(getApplicationContext(),"Invalid email , please retry",Toast.LENGTH_LONG).show();

        }
        else if (p_val == false)
        {
            Toast.makeText(getApplicationContext(),"Invalid password , please retry",Toast.LENGTH_LONG).show();
        }
        else if(r_val == false)
        {
            Toast.makeText(getApplicationContext(),"Passwords dont match , please retry",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid details , please retry",Toast.LENGTH_LONG).show();
        }



    }

    public void signin_regscreen(View v)
    {
        Intent intent1 = new Intent(getBaseContext(), Login.class);
        startActivity(intent1);
    }



}

