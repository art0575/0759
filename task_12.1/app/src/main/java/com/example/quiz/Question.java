package com.example.quiz;

import android.content.Intent;
import android.widget.TextView;

public class Question {

    private int question;
    private boolean answer;
    private String str;

    public Question(int question, boolean answer) {
        this.question = question;
        this.answer = answer;
        this.str=str;
    }

    public int getQuestion() {
        return question;
    }
    public boolean isAnswer() {
        return answer;
    }
    public String getStr() { return str; }
}