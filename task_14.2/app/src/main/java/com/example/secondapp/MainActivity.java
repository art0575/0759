package com.example.secondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView; // Создаем переменную, которая помогает подключить виджет recyclerView
    ArrayList<User> userList = new ArrayList<>(); // Создаем массив пользователей
    UserAdapter userAdapter; // Создаем объект userAdapter
    Button addUserBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview); // В переменную кладем виджет recyclerView (это список, у него есть элементы)

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)); //Необходимо воспользоваться Layout менеджером.
        // Бывают разные Layout менеджеры. Мы вибираем линейный и кладем в него активность MainActivity

        // Ранее генерирование и запись объекта были тут - ушли в recycleViewInt

        addUserBtn = findViewById(R.id.addUserBtn);
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserFormActivity.class);
                startActivity(intent);
            }
        });
    }

    /* Чтобы при закрытии активности с добавлением пользователя пользователь записывался сразу в таблицу,
       а не только после перезагрузки приложения */

    private void recyclerViewInit(){
        Users users = new Users(MainActivity.this); // В массив users возвращаем список пользователей
        userList = users.getUserList();
        userAdapter = new UserAdapter(userList); // Кладем список элементов в переменную userAdapter
        recyclerView.setAdapter(userAdapter);  // Адаптер отдаем RecyclerView
        /*for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUserName("Пользователь №"+i);
            user.setUserLastName("Фамилия №"+i);
            users.add(user);
        }*/
    }

    @Override
    public void onResume(){
        super.onResume();
        recyclerViewInit();
    }

    private  class UserHolder extends RecyclerView.ViewHolder{ // Создаем ViewHolder
        TextView itemTextView;

        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) { // Создаем конструктор.
            // Внутри принимаем 2 аргумента. 1-й Layout инфлятор, 2-й ViewGroup
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    User userTest = userAdapter.users.get (getBindingAdapterPosition());
                    //int elementchecked = getBindingAdapterPosition();
                    //String selementchecked = itemTextView.getText().toString();
                    //как выделить элемент?
                    Intent intent = new Intent(MainActivity.this, OnElementClick.class);
                    //intent.putExtra("position", elementchecked);
                    //intent.putExtra("LastName", selementchecked);
                    intent.putExtra("fulluser", (Serializable) userTest);
                    startActivity(intent);
                }
            });
        }

        public void bind(String userString){ // Создадим метод bind, который займется связкой параметров в классе UserHolder
            itemTextView.setText(userString); // В itemTextView печатаем текст userString
        }
    }

    /* Adapter помещает элементы на RecyclerView. Adapter перемещает элементы на экран.
     * Наследует все что есть у RecyclerView.
     * В <> кладем класс вьюхолдера, который нужно использовать.
     * ViewHolder - генерирует элементы списка*/
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{  //Принимаем из onCreate созданных пользователей
        ArrayList<User> users;
        public UserAdapter(ArrayList<User> users) {
            this.users = users;
        }

        // В Адаптере всегда используются 3 метода:

        /* 1-й метод родительского класса. Создает новый элемент списка
         * На вход принимает 2 аргумента. 1-й viewGroup(куда мы будем размещать наш элемент) и
         * второй getItemCount(счетчик)*/


        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this); // Создадим инфлятор. Он будет раздувать нам макет на главной активности
            return new UserHolder(inflater, viewGroup); // Возвращает  созданный элемент в RecyclerView пустым
        }

        /* 2-й метод родительского класса. Берет данные которые мы ему даем и кладет их в элемент списка
         * Используется для привязки
         * position - этот тот элемент списка, который будет отображаться на экране*/
        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            User user = users.get(position); // Достанем пользователя по идентификатору и запишем в переменную user
            String userString = user.getUserLastName()+" "+user.getUserName()+"\n"+user.getPhone(); // Обратимся к пользователю
            // и сделаем из имени и фамилии строку
            userHolder.bind(userString); // Вызываем метод bind у объекта userHolder чтобы отобразить это на экране
        }

        // 3-й метод родительского класса. Возвращает кол-во данных или элементов
        @Override
        public int getItemCount() {
            return users.size(); // Возвращаем кол-во созданных элементов
        }
    }
}