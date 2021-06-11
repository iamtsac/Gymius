package com.example.gymius;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "gymius";
    private static final int DB_VERSION = 1;

    // constructor
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // USERS TABLE
        String userQuery = "CREATE TABLE IF NOT EXISTS " + "Users" + " ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "username" + " VARCHAR,"
                + "password" + " VARCHAR)";

        // ROLES TABLE
        String rolesQuery = "CREATE TABLE IF NOT EXISTS " + "Roles" + " ("
                + "role_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "role_name" + " VARCHAR)";

        // USER ROLES TABLE
        String userRolesQuery = "CREATE TABLE IF NOT EXISTS " + "User_Roles" + " ("
                + "user_id" + " INTEGER, "
                + "role_id" + " INTEGER, "
                + "PRIMARY KEY(user_id, role_id), "
                + "FOREIGN KEY(user_id) REFERENCES Users(id), FOREIGN KEY(role_id) REFERENCES Roles(role_id) ON DELETE CASCADE ON UPDATE CASCADE)";

        // CLIENTS TABLE
        String clientQuery = "CREATE TABLE IF NOT EXISTS " + "Client" + " ("
                + "id" + " INTEGER PRIMARY KEY, "
                + "name" + " TEXT,"
                + "age" + " INT,"
                + "address" + " TEXT,"
                + "info" + " TEXT,"
                + " FOREIGN KEY(id) REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE)";

        // TRAINERS TABLE
        String trainerQuery = "CREATE TABLE IF NOT EXISTS " + "Trainer" + " ("
                + "id" + " INTEGER PRIMARY KEY, "
                + "name" + " TEXT,"
                + "speciality" + " TEXT,"
                + "salary" + " DECIMAL(5,2),"
                + "total_hours_worked" + " DECIMAL(10,2),"
                + " FOREIGN KEY(id) REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE)";

        // ADMINISTRATION TABLE
        String adminQuery = "CREATE TABLE IF NOT EXISTS " + "Administration" + " ("
                + "id" + " INTEGER PRIMARY KEY, "
                + "name" + " TEXT,"
                + "salary" + " DECIMAL(5,2),"
                + " FOREIGN KEY(id) REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE)";

        String equipmentQuery = "CREATE TABLE  IF NOT EXISTS " + "GymEquipment" + "("
                + "id" + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "type" + "TEXT CHECK(type IN ('LEGPRESS','CHESTBENCH','CROSSOVER')), "
                + "queue" + "INTEGER)";

        String sessionQuery =  "CREATE TABLE  IF NOT EXISTS " +"Sessions" + "("
                + "idsession" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name" + " TEXT,"
                + "date" + "TEXT,"
                + "time"  + "INTEGER,"
                + "program"+  "TEXT CHECK(type IN ('GYM','GROUP','SPECIAL')),"
                + "userid" +  "INTEGER,"
                + " FOREIGN KEY(id) REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE)";

        String sessionSelections = "CREATE TABLE  IF NOT EXISTS " +"Sessions" + "("
                + "sessionid" + " INTEGER PRIMARY KEY ,"
                + "name" + " TEXT,"
                + " FOREIGN KEY(sessionid) REFERENCES Sessions(idsession) ON DELETE CASCADE ON UPDATE CASCADE)";

                // ADD ANY OTHER TABLE NEEDED

        db.execSQL(userQuery);
        db.execSQL(rolesQuery);
        db.execSQL(userRolesQuery);
        db.execSQL(clientQuery);
        db.execSQL(trainerQuery);
        db.execSQL(adminQuery);
        db.execSQL(equipmentQuery);
        db.execSQL(sessionQuery);
        db.execSQL(sessionSelections);
    }

    // add new User to our DB
    public void addNewUser(String username, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        db.insert("Users", null, values);

        db.close();
    }

    // add new role to DB
    // currently available roles: Administration, Client, Trainer
    public void addNewRole(String role_name){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("role_name", role_name);

        db.insert("Roles", null, values);
    }

    // add new User Role to DB
    public void addNewUserRole(int user_id, int role_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("user_id", user_id);
        values.put("role_id", role_id);

        db.insert("User_Roles", null, values);
    }

    // add new Client to DB
    public void addNewClient(int id, String name, int age, String address, String info) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", id);
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);
        values.put("info", info);

        db.insert("Client", null, values);

        db.close();
    }

    // add new Trainer to DB
    public void addNewTrainer(int id, String name, String speciality, double salary, float total_hours_worked) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", id);
        values.put("name", name);
        values.put("speciality", speciality);
        values.put("salary", salary);
        values.put("total_hours_worked", total_hours_worked);

        db.insert("Trainer", null, values);

        db.close();
    }

    // add new Admin to DB
    public void addNewAdmin(int id, String name, double salary) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", id);
        values.put("name", name);
        values.put("salary", salary);

        db.insert("Administration", null, values);

        db.close();
    }


    //delete entry from Users table (
    public void removeUser(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Users", "username=?", new String[]{username});
        db.close();
    }

    // verifies if a User inserts the correct credentials to log in the app
    // returns if verification was successful and the table that the User is in
    public String LogInVerification(String username, String password){
        String table = "";

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT role_name FROM Roles " +
                    "INNER JOIN User_Roles ON Roles.role_id = User_Roles.role_id " +
                    "INNER JOIN Users ON Users.id = User_Roles.user_id " +
                    "WHERE Users.username = '" + username + "' AND Users.password = '" + password + "'";
        Cursor cursorLogIn = db.rawQuery(sql, null); // get role of the User that wants to log in
        if(cursorLogIn.moveToFirst()){
            table = cursorLogIn.getString(0);
        }

        cursorLogIn.close();
        return table;
    }

    public int loadUserId(String username){
        int id = 0;

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT id FROM Users WHERE username = '" + username + "'";
        Cursor cursorLogIn = db.rawQuery(sql, null);
        if(cursorLogIn.moveToFirst()){
            id = cursorLogIn.getInt(0);
        }

        cursorLogIn.close();
        return id;
    }
    public void addEquipment(String type, int queue) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("type", type.toUpperCase());
        values.put("queue", queue);

        db.insert("GymEquipment", null, values);

        db.close();
    }
    public int getQueue(int id){
        int queue_length=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT queue FROM GymEquipment " +
                "WHERE GymEquipent.id = '" + id;
        Cursor cursorQueue = db.rawQuery(sql, null); // get role of the User that wants to log in
        if(cursorQueue.moveToFirst()){
             queue_length = cursorQueue.getInt(0);
        }

        cursorQueue.close();
        return queue_length;
    }
    public void addToQueue(int id){
        int queue_len = getQueue(id);
        queue_len= queue_len++;
        String id_str = Integer.toString(id);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("queue", queue_len);


        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update("GymEquipment", values, "id=?", new String[]{id_str});
        db.close();
    }


    // function for reading all usernames in Client or Trainer table
    public ArrayList<String> loadAllUsernames(String table) {

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> usernamesArrayList = new ArrayList<>();

        switch (table) {
            case "Client" : {
                String sql = "SELECT User.username FROM " + "Client" +
                        "INNER JOIN User_Roles ON Roles.role_id = User_Roles.role_id " +
                        "INNER JOIN Users ON Users.id = User_Roles.user_id " +
                        "WHERE Roles.role_name = 'Client'";
                Cursor cursorClientUsernames = db.rawQuery(sql, null);

                if (cursorClientUsernames.moveToFirst()) {
                    do {
                        usernamesArrayList.add(cursorClientUsernames.getString(0));
                    } while (cursorClientUsernames.moveToNext());

                    cursorClientUsernames.close();
                }
                break;
            }
            case "Trainer" : {
                String sql = "SELECT User.username FROM " + "Client" +
                        "INNER JOIN User_Roles ON Roles.role_id = User_Roles.role_id " +
                        "INNER JOIN Users ON Users.id = User_Roles.user_id " +
                        "WHERE Roles.role_name = 'Trainer'";
                Cursor cursorClientUsernames = db.rawQuery(sql, null);

                if (cursorClientUsernames.moveToFirst()) {
                    do {
                        usernamesArrayList.add(cursorClientUsernames.getString(0));
                    } while (cursorClientUsernames.moveToNext());

                    cursorClientUsernames.close();
                }
                break;
            }
        }

        return usernamesArrayList;
    }
    public ArrayList<Integer> equipmentSameType(String type) {

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Integer> idList = new ArrayList<>();


        String sql = "SELECT GymEquipment.id FROM " + "GymEquipment" +
                "WHERE GymEquipment.type =" + type;
        Cursor cursorEquipType = db.rawQuery(sql, null);

        if (cursorEquipType.moveToFirst()) {
            do {
                idList.add(cursorEquipType.getInt(0));
            } while (cursorEquipType.moveToNext());

            cursorEquipType.close();
        }
        return idList;
    }


    public int ClientId (String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from Users WHERE username ="+username,null);
        int id = res.getColumnIndex("id");
        return id;
    }

    // needed function, not used in code
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + "Users");
        db.execSQL("DROP TABLE IF EXISTS " + "Client");
        db.execSQL("DROP TABLE IF EXISTS " + "Administration");
        db.execSQL("DROP TABLE IF EXISTS " + "Trainer");

        onCreate(db);
    }
}