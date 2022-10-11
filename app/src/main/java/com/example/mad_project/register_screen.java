package com.example.mad_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register_screen extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;


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

        String name= String.valueOf(ed1.getText());
        String email= String.valueOf(ed2.getText());
        String password= String.valueOf(ed3.getText());
        String re_password= String.valueOf(ed4.getText());

        email_validation obj1=new email_validation();
        boolean e_val=obj1.emailvalidate(email);

        boolean p_val=obj1.passwordvalidate(password,re_password);
        if(e_val && p_val)
        {
            Intent obj=new Intent(register_screen.this,home_screen.class);
            startActivity(obj);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid details , please retry",Toast.LENGTH_LONG).show();
        }
    }

}
//Todo : Fix register screen behenchod. Cant intent from splsh to register
