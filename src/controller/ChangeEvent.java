package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import model.pilotosModel;
//import access.pilotosDAO;
import model.carrerasModel;
import access.carrerasDAO;
import view.ControlsPanel;

public class ChangeEvent implements ActionListener {

    private ControlsPanel controlsPanel;

    public ChangeEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }

//    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//        if(actionEvent.getSource() == this.controlsPanel.getCbxPilotoList()) {
//            pilotosDAO  PilotosDAO = new pilotosDAO();
//            ArrayList<pilotosModel> Pilotos = null;
//
//            int piloto = ((pilotosModel)this.controlsPanel.getCbxPilotoList().getSelectedItem()).getCodigoPiloto();
//            if( piloto == -1) {
//                Pilotos = PilotosDAO.getAllPilotos();
//                Pilotos.add(0, new pilotosModel("Todas las presentaciones"));
//            }
//            else {
//                Pilotos = PilotosDAO.getPiloto(piloto);
//            }
////            this.controlsPanel.setCbxPresentationsList(Piloto);
//        }

        if(actionEvent.getSource() == this.controlsPanel.getCbxCarreraList()) {
            carrerasDAO  CarrerasDAO = new carrerasDAO();
            ArrayList<carrerasModel> carreras = null;

            String carrera = ((carrerasModel)this.controlsPanel.getCbxCarreraList().getSelectedItem()).getName();
            if( carrera == "") {
                carreras = CarrerasDAO.getAllCarreras();
                carreras.add(0, new carrerasModel("Todas las presentaciones"));
            }
            else {
                carreras = CarrerasDAO.getCarrera(carrera);
            }
//            this.controlsPanel.setCbxPresentationsList(Piloto);
        }

    }

}
