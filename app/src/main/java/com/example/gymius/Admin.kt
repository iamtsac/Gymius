package com.example.gymius

class Admin(var _name : String = "UNKNOWN", var _id : Int = 0, var _salary : Int = 0 ) {
    private var name = _name
    private var id = _id
    private var salary = _salary

    // name getter & setter
    fun getAdminName() : String{
        return this.name
    }
    fun setAdminName(newName : String) {
        this.name = newName
    }

    // id getter & setter
    fun getAdminId() : Int{
        return this.id
    }
    fun setAdminId(newId : Int) {
        this.id = newId
    }

    // salary getter & setter
    fun getAdminSalary() : Int{
        return this.salary
    }
    fun setAdminSalary(newSalary : Int) {
        this.salary = newSalary
    }

    // function used in Admin's UI that checks if a username exists in the database
    fun checkUsernameExists(username : String, table : String) : Boolean{
        var exists : Boolean = false

        //TODO: search into database if the "username" arg is in Client or Trainer table

        if(table == "Client") {
            //TODO
        } else if(table == "Trainer"){
            //TODO
        }
        return exists
    }

    // creates an account based on the admin's preferences
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