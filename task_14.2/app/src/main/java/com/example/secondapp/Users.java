package com.example.secondapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.secondapp.database.UserBaseHelper;
import com.example.secondapp.database.UserDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Users {
    private ArrayList<User> userList;
    private SQLiteDatabase database;
    private Context context;

    public Users(Context context) {
        this.context = context.getApplicationContext();

        /* Создаем объект UserBaseHelper, это объект класса, который отвечает за создание таблицы,
         * за изменение таблицы, помогает взаимодействовать с таблицей*/
        this.database = new UserBaseHelper(context).getWritableDatabase();
    }

    // Метод который позволяет добавлять данные в БД
    public void addUser(User user){

        // Это значение в какую колонку добавляем данные
        ContentValues values = getContentValues(user);

        //Создаем переменную которая вставляет данные в БД
        database.insert(UserDbSchema.UserTable.NAME, null,values);
    }
    public void removeUser(User user) {
        ContentValues values = getContentValues(user);
        database.delete(UserDbSchema.UserTable.NAME,UserDbSchema.Cols.UUID+"='"+user.getUuid().toString()+"'" ,null);
    }

    /* Метод который возвращает ContentValues. На вход будет принимать пользователя, с которым нужно
     * будет сопоставить колонки*/
    private static ContentValues getContentValues(User user){
        ContentValues values = new ContentValues();
        /* Сопоставляем колонки и свойства объекта user.
         * Принимает на вход название колонки и значение, которое надо положить
         * UUID это объект => переводим его в строку*/
        values.put(UserDbSchema.Cols.UUID, user.getUuid().toString());
        values.put(UserDbSchema.Cols.USERNAME, user.getUserName());
        values.put(UserDbSchema.Cols.USERLASTNAME, user.getUserLastName());
        values.put(UserDbSchema.Cols.PHONE, user.getPhone());

        // Возвращаем это values
        return values;
    }

    // Метод для чтения данных из БД в виде курсора
    private UserCursorWrapper queryUsers(){
        Cursor cursor = database.query(UserDbSchema.UserTable.NAME,null,null,null,null,null,null);
        return new UserCursorWrapper(cursor);
    }

    // Метод, который возвращает список пользователей
    public ArrayList<User> getUserList(){

        // Инициализируем пустой список
        this.userList = new ArrayList<User>();

        // Читаем значения из БД
        UserCursorWrapper cursorWrapper = queryUsers();
        try {

            // MoveToFirst - перемещает курсор на первыю запись таблицы БД
            cursorWrapper.moveToFirst();

            /* Считываем значение один за другим. Читаем до тех пор пока не закончатся символы
             * isAfterLast - после последнего. То есть если курсор не после последнего, то выполняем считывание */
            while (!cursorWrapper.isAfterLast()){
                User user = cursorWrapper.getUser();

                // Пользователя сохраним в коллекцию userList
                userList.add(user);

                // Передвигаем курсор на следующую позицию
                cursorWrapper.moveToNext();

            }
        }finally {
            cursorWrapper.close();
        }
        // Возвращаем список пользователей
        return userList;
    }
    public User getUserFromDB(UUID uuid){
        Cursor cursor = database.query(UserDbSchema.UserTable.NAME, null, UserDbSchema.Cols.UUID+"=?", new String[]{uuid.toString()}, null, null, null);
        UserCursorWrapper cursorWrapper = new UserCursorWrapper(cursor);
        cursorWrapper.moveToFirst();
        return cursorWrapper.getUser();
    }

    public void updateUser(User user){
        ContentValues values = getContentValues(user);
        String stringUuid = user.getUuid().toString();
        database.update(UserDbSchema.UserTable.NAME, values, UserDbSchema.Cols.UUID+"=?", new String[]{stringUuid});
    }

}
