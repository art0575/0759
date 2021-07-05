package com.example.secondapp;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable{
    private String userName;
    private String userLastName;
    private UUID uuid;
    private String phone;

    // Если приходит человек с пустым UUID, то присваиваем значение рандомно
    public User(){
        this.uuid = UUID.randomUUID();
    }

    /* Создадим перегрузку. Чтобы не заставлять компьютер рандомно вычислять и потом переопределять.
     * Если приходит человек со своим UUID, то пользуемся этим конструктором */
    public User(UUID uuid){
        this.uuid = uuid;
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
