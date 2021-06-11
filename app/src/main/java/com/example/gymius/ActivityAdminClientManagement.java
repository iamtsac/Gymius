package com.example.gymius;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import org.jetbrains.annotations.NotNull;

public class ActivityAdminClientManagement extends Fragment {

    EditText usernameCreateEditText, usernameDeleteEditText, passwordEditText, nameEditText, ageEditText, addressEditText, infoEditText;

    public ActivityAdminClientManagement(){
        super(R.layout.activity_admin_frag_2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_admin_frag_2, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Administration admin = new Administration();
        DBHandler dbHandler = new DBHandler(getContext());

        usernameCreateEditText = view.findViewById(R.id.username_create);
        passwordEditText = view.findViewById(R.id.password);
        nameEditText = view.findViewById(R.id.name);
        ageEditText = view.findViewById(R.id.age);
        addressEditText = view.findViewById(R.id.address);
        infoEditText = view.findViewById(R.id.info);

        usernameDeleteEditText = view.findViewById(R.id.username_delete);



        // RETURN TO HOME
        view.findViewById(R.id.admin_to_home).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_activityAdminFrag2_to_activityAdminFrag1);
            }
        });

        // CREATE CLIENT button
        view.findViewById(R.id.button_create).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username, password, name, age, address, info;

                username = String.valueOf(usernameCreateEditText.getText());
                password = String.valueOf(passwordEditText.getText());
                name = String.valueOf(nameEditText.getText());
                age = String.valueOf(ageEditText.getText());
                address = String.valueOf(addressEditText.getText());
                info = String.valueOf(infoEditText.getText());

                if(!username.equals("") && !password.equals("") && !name.equals("") && !age.equals("") && !address.equals("") && !info.equals("")){

                    admin.createAccount(dbHandler, username, password);
                    admin.createClient(dbHandler, dbHandler.loadUserId(username), name, Integer.parseInt(age), address, info);
                    Toast.makeText(getContext(), "New client account with username" + username + " successfully created!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // DELETE CLIENT button
        view.findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username;
                username = String.valueOf(usernameCreateEditText.getText());

                if(!username.equals("")) {
                    admin.deleteAccount(dbHandler, username);
                    Toast.makeText(getContext(), "Client account with username" + username + " successfully deleted!", Toast.LENGTH_LONG).show();
                } else Toast.makeText(getContext(), "Username needs to be specified", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
