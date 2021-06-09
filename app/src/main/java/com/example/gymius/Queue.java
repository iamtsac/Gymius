package com.example.gymius;

public class Queue {

    private int length;
    private float waitingTime;
    public Queue(int length,float waitingTime){
       this.length = length;
       this.waitingTime = waitingTime;
    }

   public int checkQueue(){
        return this.length;
   }

   public void addToQueue(){
       this.length++;
   }
   public void setWaitingTime(float time){
        this.waitingTime = time;
   }
}
