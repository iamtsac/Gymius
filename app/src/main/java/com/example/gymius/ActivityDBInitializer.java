package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

// dummy activity, just to initialize the DB for testing purposes
public class ActivityDBInitializer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_initializer);

        DBHandler dbHandler = new DBHandler(getApplicationContext());

        dbHandler.addNewRole("Administration"); // role_id = 1
        dbHandler.addNewRole("Client");         // role_id = 2
        dbHandler.addNewRole("Trainer");        // role_id = 3

        dbHandler.addNewUser("admin1","admin1"); // user_id = 1
        dbHandler.addNewUserRole(1, 1);
        dbHandler.addNewAdmin(1, "Jason", 1000);

        dbHandler.addNewUser("client1", "client1"); // user_id = 2
        dbHandler.addNewUserRole(2, 2);
        dbHandler.addNewClient(2, "George", 25, "Random Address 123", "height: 1.80m, weight: 70kg");

        dbHandler.addNewUser("trainer1", "trainer1"); // user_id = 3
        dbHandler.addNewUserRole(3, 3);
        dbHandler.addNewTrainer(3, "Tony", "Specialty 1", 800, 200);
        dbHandler.addEquipment("legpress", 0);
        dbHandler.CreateSession("test","1/1/2001", "12",2);

        Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
        startActivity(intent);
        finish();
    }
}