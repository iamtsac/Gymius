package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityClient extends AppCompatActivity {

    String username; // to be initialized from data sent from ActivityLogin
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        button1 = (Button) findViewById(R.id.createSessionButton);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openCreateSessionActivity();
            }
        });

        button2 = (Button) findViewById(R.id.deleteSessionButton);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openDeleteSessionActivity();
            }
        });
    }
    public void openCreateSessionActivity(){
        Intent intent = new Intent(this, CreateSessionActivity.class);
        startActivity(intent);
    }

    public void openDeleteSessionActivity(){
        Intent intent = new Intent(this, CreateSessionActivity.class);
        startActivity(intent);
    }



}