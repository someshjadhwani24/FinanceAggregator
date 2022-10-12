package com.example.mad_project;

public class User
{

    String user_name;
    long  user_id;
    String password;
    String email;
    long contact;
    boolean logged_in;

    User(String name, long id, String pass, String email, long contact, boolean logged) {
        this.user_name = name;
        this.contact = contact;
        this.user_id = id;
        this.password = pass;
        this.email = email;
        this.logged_in = logged;
    }
}

