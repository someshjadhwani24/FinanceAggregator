package com.example.mad_project;

public class email_validation {

    boolean emailvalidate(String email)
    {
        if(email.contains("@") && email.contains("."))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    boolean passwordvalidate(String password, String re_password)
    {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < password.length();i++)
        {
            ch = password.charAt(i);
            if( Character.isDigit(ch))
            {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch))
            {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch))
            {
                lowerCaseFlag = true;
            }

        }
        if(numberFlag && capitalFlag && lowerCaseFlag && password==re_password)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}
