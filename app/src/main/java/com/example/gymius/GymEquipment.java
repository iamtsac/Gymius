package com.example.gymius;

public class GymEquipment {

    private int id;
    private equipType type;
    private int daysUntilMaintenance;
    enum equipType{
        PRESSA, BENCH
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

    /*private ArrayList<GymEquipment> findSameType(GymEquipment eq){
        type = getEnum();

    }*/

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
        return queue.checkQueue();
    }
}
