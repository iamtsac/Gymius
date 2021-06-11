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

public class ActivityAdminEmployeeManagement extends Fragment {

    EditText usernameCreateEditText, usernameDeleteEditText, passwordEditText, nameEditText, specialityEditText, salaryEditText;

    public ActivityAdminEmployeeManagement(){
        super(R.layout.activity_admin_frag_3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_admin_frag_3, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState){
        //TODO
        super.onViewCreated(view, savedInstanceState);

        usernameCreateEditText = view.findViewById(R.id.username_create);
        passwordEditText = view.findViewById(R.id.password);
        nameEditText = view.findViewById(R.id.name);
        specialityEditText = view.findViewById(R.id.speciality);
        salaryEditText = view.findViewById(R.id.salary);

        usernameDeleteEditText = view.findViewById(R.id.username_delete);

        Administration admin = new Administration();
        DBHandler dbHandler = new DBHandler(getContext());

        // RETURN TO HOME button
        view.findViewById(R.id.admin_to_home).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_activityAdminFrag3_to_activityAdminFrag1);
            }
        });

        // CREATE EMPLOYEE button
        view.findViewById(R.id.button_create).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username, password, name, speciality, salary;

                username = String.valueOf(usernameCreateEditText.getText());
                password = String.valueOf(passwordEditText.getText());
                name = String.valueOf(nameEditText.getText());
                speciality = String.valueOf(specialityEditText.getText());
                salary = String.valueOf(salaryEditText.getText());

                if(!username.equals("") && !password.equals("") && !name.equals("") && !speciality.equals("") && !salary.equals("")){

                    admin.createAccount(dbHandler, username, password);
                    admin.createTrainer(dbHandler, dbHandler.loadUserId(username), name, speciality, Double.parseDouble(salary), 0);

                    Toast.makeText(getContext(), "New employee account with username" + username + " successfully created!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }


            }
        });

        // DELETE EMPLOYEE button
        view.findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username;

                username = String.valueOf(usernameDeleteEditText.getText());
                if(!username.equals("")){
                    admin.deleteAccount(dbHandler, username);
                    Toast.makeText(getContext(), "Employee account with username" + username + " successfully deleted!", Toast.LENGTH_LONG).show();

                } else Toast.makeText(getContext(), "Username needs to be specified", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
