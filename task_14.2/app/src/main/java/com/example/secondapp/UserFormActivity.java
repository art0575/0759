package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserFormActivity extends AppCompatActivity {
    Button insertUserBtn;
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextPhone;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        user = (User) getIntent().getSerializableExtra("fulluser");
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPhone = findViewById(R.id.editTextPhone);
        insertUserBtn = findViewById(R.id.insertUserBtn); // Находим кнопку на форме
        if(user != null){ // Если редактируем юзера
            editTextName.setText(user.getUserName());
            editTextLastName.setText(user.getUserLastName());
            editTextPhone.setText(user.getPhone());
        }else{ // если добавляем нового
            user = new User();
        }

        insertUserBtn.setOnClickListener(new View.OnClickListener() {  // Навешиваем на кнопку обработчик клика
            @Override
            public void onClick(View view) {
                // Добавляем остальные свойства. Читаем из текстовых полей на форме, в которые мы печатаем данные
                user.setUserName(editTextName.getText().toString());
                user.setUserLastName(editTextLastName.getText().toString());
                user.setPhone(editTextPhone.getText().toString());

                // Добавляем пользователя
                Users users = new Users(UserFormActivity.this);
                if (user!= null) users.updateUser(user);
                else users.addUser(user);
                users.addUser(user);

                // Возвращаемся к списку пользователей. Возвращаемся на предыдущую активность
                onBackPressed();
            }
        });

    }
}