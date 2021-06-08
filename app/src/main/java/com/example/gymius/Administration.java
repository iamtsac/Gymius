package com.example.gymius;

import java.util.ArrayList;

public class Administration {
    private int id;
    private String name;
    private double salary;

    public Administration(){
        this.id = 0;
        this.name = "UNKNOWN";
        this.salary = 0.0;
    }
    public Administration(int _id, String _name, double _salary){
        this.id = _id;
        this.name = _name;
        this.salary = _salary;
    }

    // GETTERS
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getSalary(){
        return this.salary;
    }

    // SETTERS
    public void setId(int newId){
        this.id = newId;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setSalary(int newSalary){
        this.salary = newSalary;
    }

    // checks if a username exists in the database
    public boolean checkUsernameExists(DBHandler dbHandler, String username){
        boolean exists = false;

        //TODO

        return exists;
    }

    // creates an entry in the db so that the user can connect to the app
    public void createAccount(DBHandler dbHandler, String username, String password, String table){
        dbHandler.addNewUser(username, password);
    }
    public void createClient(DBHandler dbHandler ,int id, String name, int age, String address, String info){
        dbHandler.addNewClient(id, name, age, address, info);
    }
    public void createTrainer(DBHandler dbHandler, int id, String name, String speciality, double salary, float total_hours_worked){
        dbHandler.addNewTrainer(id, name, speciality, salary, total_hours_worked);
    }



    // deletes an account based on the admin's chosen id
    public void deleteAccount(DBHandler dbHandler, String username){
        dbHandler.removeUser(username);
    }

    public void loadAllUsernames(DBHandler dbHandler, String table){
        ArrayList<String> usernamesArrayList = dbHandler.loadAllUsernames(table);
    }

}
