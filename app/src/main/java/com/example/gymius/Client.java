package com.example.gymius;

import com.example.gymius.ui.login.Help_Request;
import com.example.gymius.ui.login.Subscription;

public class Client {

    private String name, home_address;
    private int age, id;
    private String personal_info;
    private int SubscriptionId;

    public Client(String name, String home_address, int age, int id) {
        this.name = name;
        this.home_address = home_address;
        this.age = age;
        this.id = id;
        this.getSubscriptionId();
    }

    public void getSessionList(){

}

    public void createSession () {

}

    public void newHelpRequest(){
        //tha pairnei san input to mhxanhma opou vrisketai o client
        //tha pairnei to id tou mhxanhmatos apo to database
        //kai tha dhmiourgei ena neo help request
        Help_Request HelpRequest = new Help_Request(id,1);
}

    public void getSubscriptionId (){
        // to systhma pairnei to id toy client kai anazhta sthn vash an yparxei kapoio sub me auto to id
        // gyrnaei to info kai to settarei sto sub
        // me auto ton tropo tha mporoume na elegxoume an enas client exei dikaiwma prosvashs sta feature tou app
    }

}