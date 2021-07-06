package com.example.secondapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class OnElementClick extends AppCompatActivity {

    Button deleteUserBtn;
    Button editUserInfo;
    EditText showTextName;
    EditText showTextLastName;
    EditText showTextPhone;
    User user;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_element_click);
        users=new Users(OnElementClick.this);
        user = (User) getIntent().getSerializableExtra("fulluser");
        showTextName = findViewById(R.id.showTextName);
        showTextLastName = findViewById(R.id.showTextLastName);
        showTextPhone = findViewById(R.id.showTextPhone);showTextName.setText(user.getUserName());
        showTextLastName.setText(user.getUserLastName());
        showTextPhone.setText(user.getPhone());
        deleteUserBtn = findViewById(R.id.deleteUserBtn);
        deleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users = new Users(OnElementClick.this);
                users.removeUser(user);
                onBackPressed();
            }
        });
        editUserInfo = findViewById(R.id.editUserInfo);
        editUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setUserName(showTextName.getText().toString());
                user.setUserLastName(showTextLastName.getText().toString());
                user.setPhone(showTextPhone.getText().toString());
                users.updateUser(user);
                onBackPressed();
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        user = users.getUserFromDB(user.getUuid());
        showTextName = findViewById(R.id.showTextName);
        showTextLastName = findViewById(R.id.showTextLastName);
        showTextPhone = findViewById(R.id.showTextPhone);
        showTextName.setText(user.getUserName());
        showTextLastName.setText(user.getUserLastName());
        showTextPhone.setText(user.getPhone());
    }
}