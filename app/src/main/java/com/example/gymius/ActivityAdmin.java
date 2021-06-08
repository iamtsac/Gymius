package com.example.gymius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityAdmin extends AppCompatActivity {
    public ActivityAdmin(){
        super(R.layout.activity_admin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.admin_nav_host_fragment, ActivityAdminFrag1.class, null)
                    .commit();
        }

    }
}