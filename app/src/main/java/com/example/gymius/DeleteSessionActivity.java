package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class DeleteSessionActivity extends AppCompatActivity {

    Button deleteTheSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_session);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner5);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(DeleteSessionActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sessions));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        deleteTheSession = findViewById(R.id.deleteTheSession);
        deleteTheSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),DeleteSessionActivity.class);
                startActivity(intent1);
            }
        });



    }
}