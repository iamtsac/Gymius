package com.example.gymius;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import org.jetbrains.annotations.NotNull;

public class ActivityAdminFrag2 extends Fragment {
    public ActivityAdminFrag2(){
        super(R.layout.activity_admin_frag_2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_admin_frag_2, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState){
        //TODO
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.admin_button3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_activityAdminFrag2_to_activityAdminFrag1);
            }
        });
    }
}
