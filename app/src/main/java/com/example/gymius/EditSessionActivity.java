package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class EditSessionActivity extends AppCompatActivity {

    Button editSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_session);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EditSessionActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sessions));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        editSession = findViewById(R.id.editSessionButton2);
        editSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),edit_session_level2.class);
                startActivity(intent1);
            }
        });


    }

}