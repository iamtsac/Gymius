package com.example.gymius;

public class Subscription {

    private enum SubType{
        MHNIAIA, TRIMHNH, EKSAMHNH, ETHSIA
    }
    private SubType Subscription_type;
    private int duration; //hmeres
    private int id; //

    public Subscription(SubType subscription_type, int duration) {
        Subscription_type = subscription_type;
        this.duration = duration;
    }

    public SubType getSubscription_type() {
        return Subscription_type;
    }

    public void setSubscription_type(SubType subscription_type) {
        Subscription_type = subscription_type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void createSubDatabase (){
        // dhmiourgei ena neo entry sto database gia to neo sub
        //gyrnaei to id tou sub
    }
}
