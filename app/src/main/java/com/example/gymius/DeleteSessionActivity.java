package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DeleteSessionActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_session);
        listView = (ListView)findViewById((R.id.listview));

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("hope");
        arrayList.add("its");
        arrayList.add("working");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,arrayList);

        listView.setAdapter(arrayAdapter);
    }
}