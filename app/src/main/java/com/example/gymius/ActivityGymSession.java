package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class ActivityGymSession extends AppCompatActivity {

    String username; // to be initialized from data sent from ActivityLogin
    Button cancelButton,submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gym_session);

        cancelButton = findViewById(R.id.gym_cancel);
        submitButton = findViewById(R.id.gym_submit);



        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

