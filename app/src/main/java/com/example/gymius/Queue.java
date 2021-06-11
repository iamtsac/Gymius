package com.example.gymius;


import android.content.Context;

public class Queue {

    private int length;
    private float waitingTime;


    public Queue(int length,float waitingTime){
       this.length = length;
       this.waitingTime = waitingTime;
    }

    public int checkQueue(int id){
        DBHandler dbHandler = new DBHandler(getApplicationContext());
        return dbHandler.getQueue(id);
   }

   public void addToQueue(int id){
       DBHandler dbHandler = new DBHandler(getApplicationContext());
       dbHandler.addToQueue(id);

   }
   public void setWaitingTime(float time){
        this.waitingTime = time;
   }
}
