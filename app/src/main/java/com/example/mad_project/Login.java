package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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

        User_Database db=new User_Database(this);
        Cursor res=db.viewuseremail(email);
        if(res.getCount()==0)
        {
            System.out.println("String false");
        }
        StringBuffer b=new StringBuffer();
        String db_password=null;
        String db_email=null;
        String db_username=null;
        long db_userid=0;
        while(res.moveToNext())
        {
             db_password = res.getString(3);
             db_email = res.getString(2);
             db_username = res.getString(1);
             db_userid = res.getInt(0);
        }

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
