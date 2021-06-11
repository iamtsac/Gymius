package com.example.gymius;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ActivityAdminMainFragment extends Fragment {
    public ActivityAdminMainFragment(){
        super(R.layout.activity_admin_frag_1);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_admin_frag_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);

        // TO FRAGMENT 2
        view.findViewById(R.id.admin_button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_activityAdminFrag1_to_activityAdminFrag2);
            }
        });

        // TO FRAGMENT 3
        view.findViewById(R.id.admin_button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_activityAdminFrag1_to_activityAdminFrag3);
            }
        });
    }
}
