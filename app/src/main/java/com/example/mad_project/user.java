package com.example.mad_project;

public class user
{

    String user_name;
    String user_id;
    String password;
    String email;
    long contact;
    boolean logged_in;

    user(String name, String id, String pass, String email, long contact, boolean logged) {
        this.user_name = name;
        this.contact = contact;
        this.user_id = id;
        this.password = pass;
        this.email = email;
        this.logged_in = logged;
    }
}

