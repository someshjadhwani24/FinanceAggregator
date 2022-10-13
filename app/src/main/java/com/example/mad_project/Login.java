package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void sign_up(View v)
    {
        Intent obj=new Intent(Login.this,register_screen.class);
        startActivity(obj);
    }

    public void login(View v)
    {
        ed1=(EditText) findViewById(R.id.enter_email);
        ed2=(EditText) findViewById(R.id.enter_password);

        String email= String.valueOf(ed1.getText());
        String password=String.valueOf(ed2.getText());

        String db_password = "Appleipod1";
        String db_email = "somesh@gmail.com";
        String db_username = "Somesh Jadhwani";
        long db_userid = 704720;
        if(password.equals(db_password) && db_email.length() >0)
        {

            User current_user = new User();
            User.email =db_email;
            User.user_name = db_username;
            User.user_id = db_userid;
            User.password = db_password;
            User.logged_in = true;

            Intent obj=new Intent(Login.this,home_screen.class);
            startActivity(obj);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid Login Credentials, please retry",Toast.LENGTH_LONG).show();
        }
    }
}
