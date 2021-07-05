package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.secondapp.database.UserDbSchema;

import java.io.Serializable;

public class OnElementClick extends AppCompatActivity {

    Button deleteUserBtn;
    EditText showTextName;
    EditText showTextLastName;
    EditText showTextPhone;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_element_click);
        //String selementchecked = getIntent().getStringExtra("LastName");
        //int elementchecked = getIntent().getIntExtra("position",0);


        showTextName = findViewById(R.id.showTextName);
        showTextLastName = findViewById(R.id.showTextLastName);
        showTextPhone = findViewById(R.id.showTextPhone);

        user = (User) getIntent().getSerializableExtra("fulluser");
        showTextName.setText(user.getUserName());
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
    }
}