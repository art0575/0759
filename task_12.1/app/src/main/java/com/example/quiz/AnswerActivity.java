package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        answerTextView=findViewById(R.id.answerTextView);
        boolean inAnswerTrue = getIntent().getBooleanExtra("answer", false);
        answerTextView.setText(inAnswerTrue ? "да": "нет");
    }
}