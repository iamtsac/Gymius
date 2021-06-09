package com.example.gymius;

public class Session {

    private String availableTimeSlots,workoutSchedule;
    private int id;
    public void setAvailableTimeSlots(String availableTimeSlots){
        this.availableTimeSlots = availableTimeSlots;
    }
    public String getAvailableTimeSlots(){
        return availableTimeSlots;
    }
    public void setWorkoutSchedule(String workoutSchedule){
        this.workoutSchedule = workoutSchedule;
    }
    public String getWorkoutSchedule(){
        return workoutSchedule;
    }


    public void addToProgram(GymEquipment equi){
        //prosthetei to organo gumnastikhs sto programma

    }

    public void addToProgram(SpecialServices service){
        //prosthetei thn eidikh uphresia sto programma
    }

    public void addToProgram(GroupProgram program){
        //prosthetei to omadiko programma sto programma
    }


    public void RemoveFromSession(GroupProgram program){
        //afairei to omadiko programma apo to programma
    }

    public void RemoveFromSession(SpecialServices service){
        //afairei thn eidikh yphresia apo to programma
    }

    public void RemoveFromSession(GymEquipment equipment){
        //afairei to organo gymnastikhs apo to programma
    }

    public void getInstrumentsInSession(int id){
        //pairnei ta organa tou session apo th vash dedomenwn
    }

    public void getTrainingProgramsInSession(int id){
        //pairnei ta omadika programmata tou session apo th vash dedomenwn
    }

    public void getSpecialServicesInSession(int id){
        //pairnei tis eidikes uphresies apo
    }

    public void SaveSession(int id){
        //kanei save to session apo th vash dedomenwn
    }

    public void deleteSession(int id){
        //kanei delete to session apo th vash dedomenwn
    }

}
