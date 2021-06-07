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

        // ADD ANY OTHER TABLE NEEDED

        db.execSQL(userQuery);
        db.execSQL(rolesQuery);
        db.execSQL(userRolesQuery);
        db.execSQL(clientQuery);
        db.execSQL(trainerQuery);
        db.execSQL(adminQuery);
    }

    // add new User to our DB
    public void addNewUser(String username, String password) {

        // creating a variable for our DB
        // and calling writable method
        // as we are writing data in our DB.
        SQLiteDatabase db = this.getWritableDatabase();

        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("username", username);
        values.put("password", password);

        db.insert("Users", null, values);

        db.close();
    }

    // add new role to our DB
    // currently available roles: Administration, Client, Trainer
    public void addNewRole(String role_name){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("role_name", role_name);

        db.insert("Roles", null, values);
    }

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
                    "INNER JOIN Users ON User.id = User_Roles.user_id " +
                    "WHERE Users.username = " + username + " AND Users.password = " + password;
        Cursor cursorLogIn = db.rawQuery(sql, null); // get role of the User that wants to log in
        if(cursorLogIn.moveToFirst()){
            table = cursorLogIn.getString(1);
        }

        cursorLogIn.close();
        return table;
    }

    // method for reading all the Clients in DB (example function)
    public ArrayList<Client> readClients() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorClients = db.rawQuery("SELECT name, address, age, id FROM " + "Users", null);

        // on below line we are creating a new array list.
        ArrayList<Client> clientsArrayList = new ArrayList<>();

        // moving our cursor to first position. //public Client(String name, String home_address, int age, int id)
        if (cursorClients.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                clientsArrayList.add(new Client(cursorClients.getString(1),
                        cursorClients.getString(2),
                        cursorClients.getInt(3),
                        cursorClients.getInt(4)));
            } while (cursorClients.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorClients.close();
        return clientsArrayList;
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