package com.codeup.adlister.dao;

public class Config {
    public String getUrl() {
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }

    public String getUser() {
        return "adlister";
    }

    public String getPassword() {
        return "";
    }
}
