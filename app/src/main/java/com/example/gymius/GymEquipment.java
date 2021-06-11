package com.example.gymius;

import java.util.ArrayList;

public class GymEquipment {

    private int id;
    private equipType type;
    private int daysUntilMaintenance;
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

    public void addToDatabase(DBHandler dbHandler){
        dbHandler.addEquipment(this.type.toString(),0);
    }

    private ArrayList<Integer> findSameType(DBHandler dbHandler){
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

    public int getQueueLength(DBHandler dbHandler){

        return queue.checkQueue(this.id,dbHandler);
    }
    public void addToQueue(DBHandler dbHandler){
        queue.addToQueue(this.id,dbHandler);
    }
}
