package com.example.gymius;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;



public class ActivityCreateSession extends AppCompatActivity {

    Button gymButton,groupButton,specialButton,submitButton, cancelButton;
    EditText session_name,session_date,session_time;
    String name,date,time,username;
    int clientID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_session);
        DBHandler db = new DBHandler(getApplicationContext());


        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        clientID = db.loadUserId(username);


        gymButton = findViewById(R.id.gym_but);
        groupButton = findViewById(R.id.group_but);
        specialButton = findViewById(R.id.special_button);
        submitButton = findViewById(R.id.submit_ses);
        cancelButton = findViewById(R.id.cancel_ses);



        gymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivityGymSession.class);

                //intent.putExtra("clientID",clientID);
                startActivity(intent);
            }
        });

        groupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivityGroupSession.class);
                startActivity(intent);
            }
        });

        specialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivitySpecialSession.class);
                startActivity(intent);
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session_name = findViewById(R.id.session_name);
                session_date = findViewById(R.id.session_date);
                session_time = findViewById(R.id.session_time);

                name = String.valueOf(session_name.getText());
                date = String.valueOf(session_date.getText());
                time = String.valueOf(session_time.getText());

                if(!name.isEmpty() && !date.isEmpty() && !time.isEmpty()){
                    db.CreateSession(name,date,time,clientID);
                }
                finish();
            }


        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
