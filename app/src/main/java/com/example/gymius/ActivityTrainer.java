package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ActivityTrainer extends AppCompatActivity {

    String username; // to be initialized from data sent from ActivityLogin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
    }
}