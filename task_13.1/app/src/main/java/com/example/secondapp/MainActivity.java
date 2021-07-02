package com.example.secondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView; //Отображает элементы на экране через настройки в xml
    ArrayList<User> users = new ArrayList<>(); //Создаем коллекцию для элементов
    UserAdapter userAdapter; // Имя для объекта Адаптера

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // обращение к MainActivity
        recyclerView = findViewById(R.id.recyclerview);//находим по id наш RecycleView
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));// Обращение к менеджеру (LayoutManager)
        // передаваемоему элементы списка в сам список (RecycleView), LinerLayout-вид размещения элементов списка,
        // друг под другом. В MainActivity.
        for (int i = 0; i < 100; i++) { // Цикл из 100 элементов с указанием "Пользователь №" и "Фамилия №";
            User user = new User();// создаем элемент коллекции
            user.setUserName("Пользователь №" + i);
            user.setUserLastName("Фамилия №" + i);
            users.add(user);// добавляем элементы в коллекцию users
        }
        userAdapter = new UserAdapter(users); // создание объекта адаптера UserAdapter
        recyclerView.setAdapter(userAdapter); // связывание Списка (recycleView) с Адаптером
    }

    private class UserHolder extends RecyclerView.ViewHolder { // Генерирует элементы списка, наследник RecyclerView
        TextView itemTextView; // Имя для элемента текстового поля, каркаса RecycleView

        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) { //конструктор для создания элемента текстового поля,
            // с двумя компонентами infFlatter(надуватель) макета списка, ViewGroup-макет списка
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);// itemView - текущий элемент для добавления в
            // строку поля itemTextView - находим по id в xml файле.
        }

        public void bind(String userString) {// метод для отображения элементов на экран
            itemTextView.setText(userString);//добавляем элементы коллекции (users) в элементы текстогого поля (itemTextView)
        }
    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder> {  // Адаптер -для передачи элементов на recycleView наследник
        // RecyclerView.Adapter использующий ViewHolder
        ArrayList<User> users; // Инициализация Коллекции users

        public UserAdapter(ArrayList<User> users) {
            this.users = users;
        } //конструктор

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) { //метод вызывается для создания каждого элемент списка
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {  //метод для передачи данных в элемент списка (макета)
            User user = users.get(position); // получение позиции коллекции
            String userString = user.getUserName() + "\n" + user.getUserLastName(); //составление текста
            userHolder.bind(userString);// добавление в элемент списка
        }

        @Override
        public int getItemCount() {  //возвращает количество элементов для размещения на экране
            return users.size();
        }
    }
}