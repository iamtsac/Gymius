package com.example.gymius;

public class Help_Request {

    private int idHelpRequest, idClient;
    private int idEquipment;

    public Help_Request(int idClient, int idEquipment) {
        this.idClient = idClient;
        this.idEquipment = idEquipment;
        this.CreateHelpRequest();
    }

    public void CreateHelpRequest(){
        //dhmiourgei ena neo help req sto database otan dhmiourghthei ena neo antikeimeno help_request
        // h vash gyrnaei to id tou neou aithmatos
        idHelpRequest = 1; //create new help req to database and get the id,
    }

    public int getIdHelpRequest() {
        return idHelpRequest;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdEquipment() {
        return idEquipment;
    }
}
