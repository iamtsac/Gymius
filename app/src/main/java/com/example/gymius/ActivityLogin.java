package com.example.gymius;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button loginButton;
    ProgressBar loginProgressBar;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        loginProgressBar = findViewById(R.id.login_loading);

        DBHandler dbHandler = new DBHandler(getApplicationContext());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password;

                username = String.valueOf(usernameEditText.getText());
                password = String.valueOf(passwordEditText.getText());

                loginProgressBar.setVisibility(ProgressBar.VISIBLE);

                if(!username.equals("") && !password.equals("")) {

                    String table = dbHandler.LogInVerification(username, password);

                    switch (table) {
                        case "Administration": {
                            loginProgressBar.setVisibility(ProgressBar.INVISIBLE);
                            Intent intent = new Intent(getApplicationContext(), ActivityAdmin.class);
                            startActivity(intent);
                            //finish();
                            break;
                        }
                        case "Client": {
                            loginProgressBar.setVisibility(ProgressBar.INVISIBLE);
                            Intent intent = new Intent(getApplicationContext(), ActivityClient.class);
                            startActivity(intent);
                            //finish();
                            break;
                        }
                        case "Trainer": {
                            loginProgressBar.setVisibility(ProgressBar.INVISIBLE);
                            Intent intent = new Intent(getApplicationContext(), ActivityTrainer.class);
                            startActivity(intent);
                            //finish();
                            break;
                        }
                        default:
                            Toast.makeText(getApplicationContext(), "Oops, something went wrong.", Toast.LENGTH_SHORT).show();
                            break;
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
