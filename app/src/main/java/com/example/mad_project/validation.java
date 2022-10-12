package com.example.mad_project;

public class validation {

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
        if(numberFlag && capitalFlag && lowerCaseFlag && password.equals(re_password) && password!=null)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    boolean login_validate(String user_email,String user_pass,String db_pass)
    {
        if(emailvalidate(user_email) && user_pass.equals(db_pass))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        String address = "somesh_jadhwani01@hotmail.com";
        validation obj1 = new validation();
        if (obj1.emailvalidate(address))
        {
            System.out.println("This works");
        }
        else{
            System.out.println("Failure");
        }
    }

}
