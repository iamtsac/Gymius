package com.example.gymius;

public class GymEquipment {

    private int id;
    private equipType type;
    private int daysUntilMaintenance;
    enum equipType{
        PRESSA, BENCH
    }

    public void GymEquipment(int id, equipType type){
        this.id = id;
        this.type = type;
    }

    public void setDaysUntilMaintenance(int days){
        this.daysUntilMaintenance = days;
    }

    public equipType getEnum(){
        return type;
    }

    /*private ArrayList<GymEquipment> findSameType(GymEquipment eq){
        type = getEnum();

    }*/
}
