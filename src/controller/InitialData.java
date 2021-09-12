package controller;

import java.util.ArrayList;
//import access.pilotosDAO;
//import model.pilotosModel;
import access.carrerasDAO;
import model.carrerasModel;


public class InitialData {
//    private ArrayList<pilotosModel> pilotos = null;
    private ArrayList<carrerasModel> carreras = null;

    public InitialData(){

//        pilotosDAO Pilotos = new pilotosDAO();
//        this.pilotos = Pilotos.getAllPilotos();
//        this.pilotos.add( new pilotosModel("Todos los pilotos"));
        carrerasDAO carreras = new carrerasDAO();
        this.carreras = carreras.getAllCarreras();
//        this.carreras.add( new carrerasModel("Todas las carreras"));

    }

    public ArrayList<carrerasModel> getCarreras() {
        return carreras;
    }


}