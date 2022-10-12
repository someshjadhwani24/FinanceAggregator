package com.example.mad_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        validation obj1=new validation();
        boolean e_val=obj1.emailvalidate(email);
        boolean p_val=obj1.passwordvalidate(password,password);
        boolean r_val = password.equals(re_password);
        System.out.println(r_val);
        System.out.println(password);
        System.out.println(re_password);
        System.out.println(p_val);
        if(e_val && p_val && r_val)
        {
            Intent obj=new Intent(register_screen.this,home_screen.class);
            obj.putExtra("message_key",name);
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
        Intent intent1 = new Intent(getBaseContext(),login.class);
        startActivity(intent1);
    }

}
//Todo : Fix register screen behenchod. Cant intent from splsh to register
