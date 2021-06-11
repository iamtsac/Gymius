package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditSessionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_session);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EditSessionActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sessions));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
//        asadasdasd

    }

}