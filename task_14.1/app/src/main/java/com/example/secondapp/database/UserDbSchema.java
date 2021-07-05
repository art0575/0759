package com.example.secondapp.database;

public class UserDbSchema {
    public static final class UserTable{
        public static final String NAME = "users"; // Название таблицы БД
    }
    public static final class Cols{
        public static final String UUID = "uuid";
        public static final String USERNAME = "user_name";
        public static final String USERLASTNAME = "user_last_name";
        public static final String PHONE = "phone";

    }
}
