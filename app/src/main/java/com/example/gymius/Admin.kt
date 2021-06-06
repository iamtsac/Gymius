package com.example.gymius

class Admin(var _name : String = "UNKNOWN", var _id : Int = 0, var _salary : Int = 0 ) {
    private var name = _name
    private var id = _id
    private var salary = _salary

    // name getter & setter
    fun getName() : String{
        return this.name
    }
    fun setName(newName : String) {
        this.name = newName.capitalize()
    }

    // id getter & setter
    fun getId() : Int{
        return this.id
    }
    fun setId(newId : Int) {
        this.id = newId
    }

    // salary getter & setter
    fun getSalary() : Int{
        return this.salary
    }
    fun setSalary(newSalary : Int) {
        this.salary = newSalary
    }

    // checks if a username exists in the database
    fun checkUsernameExists(username : String, table : String) : Boolean{
        var exists : Boolean = false

        //TODO: search into database if the "username" arg is in Client or Trainer table

        if(table == "Client") {
            //TODO
        } else if(table == "Trainer"){
            // creates an account based on the admin's preferences
            //TODO
        }
        return exists
    }

    fun createAccount(username : String, password : String, table : String){

        //TODO: insert new entry in the database in Client or Trainer table

        if(table == "Client"){
            //TODO
        } else if(table == "Trainer"){
            //TODO
        }
    }

    // deletes an account based on the admin's chosen id
    fun deleteAccount(id : Int, table : String){

        //TODO: delete an entry from the database in Client or Trainer table
        if(table == "Client"){
            //TODO
        } else if(table == "Trainer"){
            //TODO
        }
    }

}