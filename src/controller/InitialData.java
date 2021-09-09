package controller;

import java.util.ArrayList;
import access.pilotosDAO;
import model.pilotosModel;


public class InitialData {
    private ArrayList<pilotosModel> pilotos = null;

    public InitialData(){

        pilotosDAO Pilotos = new pilotosDAO();
        this.pilotos = Pilotos.getAllPilotos();
        this.pilotos.add( new pilotosModel("Todos los pilotos"));

    }

    public ArrayList<pilotosModel> getPilotos() {
        return pilotos;
    }


}