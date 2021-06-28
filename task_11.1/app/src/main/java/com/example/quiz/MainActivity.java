package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button yesBtn;
    private Button noBtn;
    private TextView questionTextView;

    private Question[] questions = {
            new Question(R.string.question,true),
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true)
    };
    private  int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO","Метод onCreate() запущен");
        if (savedInstanceState != null)
        questionIndex = savedInstanceState.getInt("question", 0);

        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(questions[questionIndex].getQuestion());

        yesBtn = findViewById(R.id.yesBtn);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions[questionIndex].isAnswer()){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
                questionIndex = (questionIndex + 1)%questions.length;
                questionTextView.setText(questions[questionIndex].getQuestion());


            }
        });

        noBtn = findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!questions[questionIndex].isAnswer()){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
                questionIndex = (questionIndex + 1)%questions.length;
                questionTextView.setText(questions[questionIndex].getQuestion());
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SYSTEM INFO","Метод onStart() запущен");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SYSTEM INFO","Метод onDestroy() запущен");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SYSTEM INFO","Метод onResume() запущен");
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Log.d("SYSTEM INFO","Метод onSaveInstanceState() запущен");
        saveInstanceState.putInt("question", questionIndex);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SYSTEM INFO","Метод onPause() запущен");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SYSTEM INFO","Метод onStop() запущен");
    }
}
