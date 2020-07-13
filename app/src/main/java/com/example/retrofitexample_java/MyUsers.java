package com.example.retrofitexample_java;

import com.google.gson.annotations.SerializedName;

public class MyUsers {

    //Give the field a custom fields
    @SerializedName("name")
    private String the_name;

    @SerializedName("username")
    private String the_username;


    @SerializedName("email")
    private String the_email;


    //create a constructor
    public MyUsers(String the_name, String the_username, String the_emeail) {
        this.the_name = the_name;
        this.the_username = the_username;
        this.the_email = the_emeail;
    }


    //Retrieve the data using setter/getter methods//
    public String getThe_name() {
        return the_name;
    }

    public void setThe_name(String the_name) {
        this.the_name = the_name;
    }

    public String getThe_username() {
        return the_username;
    }

    public void setThe_username(String the_username) {
        this.the_username = the_username;
    }

    public String getThe_email() {
        return the_email;
    }

    public void setThe_email(String the_email) {
        this.the_email = the_email;
    }
}
