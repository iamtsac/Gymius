package com.example.gymius;

import java.util.ArrayList;

public class GymEquipment {

    private int id;
    private equipType type;
    private int daysUntilMaintenance;
    DBHandler dbHandler = new DBHandler(getApplicationContext());
    enum equipType{
        LEGPRESS,CHESTBENCH,CROSSOVER
    }

    public GymEquipment(int id, equipType type) {
        this.id = id;
        this.type = type;
    }
    private Queue queue = new Queue(0, (float) 0.00);

    public void setDaysUntilMaintenance(int days){
        this.daysUntilMaintenance = days;
    }

    public equipType getEnum(){
        return type;
    }

    public void addToDatabase(){
        dbHandler.addEquipment(this.type.toString(),0);
    }

    private ArrayList<Integer> findSameType(){
        return dbHandler.equipmentSameType(this.type.toString());

    }

    public int getId() {
        return id;
    }

    public equipType getType() {
        return type;
    }

    public int getDaysUntilMaintenance() {
        return daysUntilMaintenance;
    }

    public int getQueueLength(){
        return queue.checkQueue(this.id);
    }
    public void addToQueue(){
        queue.addToQueue(this.id);
    }
}
