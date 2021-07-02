package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;


public class AnswerUser extends AppCompatActivity {
    private TextView text;
    private Button repeatBtn;
    private Button closeBtn;
    private int trueAnswer, in;
    private String str, str2;
    private String[] u2 = new String[10];
    private String[] u3 = new String[10];
    private int[] i1 = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_user);


        text = findViewById(R.id.textView2);
        repeatBtn = findViewById(R.id.repeatBtn);
        closeBtn = findViewById(R.id.closeBtn);
        text.setMovementMethod(new ScrollingMovementMethod());
        u2 = getIntent().getStringArrayExtra("u2");
        u3 = getIntent().getStringArrayExtra("u3");
        for (String str : u3) {
            if (str.equals("Правильно")) {
                trueAnswer++;
            }
        }
        text.append("Вы заработали " + String.valueOf(trueAnswer * 10) + " баллов из 100" + "\n" +
                "Ваши ответы: " + "\n");
        for (int i = 0; i < u2.length; i++) {
            text.append(u2[i]+ " - " + u3[i] + "\n");}

        repeatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO", "Метод onSaveInstanceState() запущен");
    }
}

