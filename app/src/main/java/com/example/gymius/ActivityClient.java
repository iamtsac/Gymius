package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityClient extends AppCompatActivity {

    String username; // to be initialized from data sent from ActivityLogin
    TextView usernameEdit;
    Button createSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");


        usernameEdit = findViewById(R.id.clientUsername);
        usernameEdit.setText(username);
        createSession = findViewById(R.id.createSessionButton);

        createSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),ActivityCreateSession.class);
                startActivity(intent1);
            }
        });


    }
}