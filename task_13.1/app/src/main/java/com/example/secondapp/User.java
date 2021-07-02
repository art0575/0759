package com.example.secondapp;

import java.util.UUID;

public class User {
    private String userName;
    private String userLastName;
    private UUID uuid;
    private String phone;
    public User(){
        this.uuid = UUID.randomUUID();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UUID getUuid() {
        return uuid;
    }
}