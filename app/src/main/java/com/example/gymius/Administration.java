package com.example.gymius;

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
    public boolean checkUsernameExists(String username, String table){
        boolean exists = false;
        //TODO
        if (table == "Client"){

        } else if(table == "Trainer"){

        }
        return exists;
    }

    // creates an entry in the db so that the user can connect to the app
    public void createAccount(String username, String password, String table){
        //TODO
        if(table == "Client"){

        } else if(table == "Trainer"){

        }
    }

    // deletes an account based on the admin's chosen id
    public void deleteAccount(int id, String table){
        //TODO
        if(table == "Client"){

        } else if(table == "Trainer"){

        }
    }

}
