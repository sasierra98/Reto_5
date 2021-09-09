package controller;

//import access.pilotosDAO;
import access.carrerasDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//import model.pilotosModel;
import model.carrerasModel;
import view.ControlsPanel;
//import view.AddArtPiece;
//import view.ControlsPanel;

public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;

    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }

    /// nuevo
//    public ClickEvent(Object controlsPanel) {
//
//    }
    ////

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
//            int codigoPiloto  = ((pilotosModel)this.controlsPanel.getCbxPilotoList().getSelectedItem()).getCodigoPiloto();
//
//            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
//            pilotosDAO PilotosDAO = new pilotosDAO();
//            ArrayList<pilotosModel> piloto = PilotosDAO.getAllPilotos();
//
//            this.controlsPanel.setTblResults(piloto);
//        }

        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            String codigoPiloto  = ((carrerasModel)this.controlsPanel.getCbxCarreraList().getSelectedItem()).getName();

            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            carrerasDAO CarrerasDAO = new carrerasDAO();
            ArrayList<carrerasModel> carreras = CarrerasDAO.getAllCarreras();

            this.controlsPanel.setTblResults(carreras);
        }

//        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddArtPiece()) {
//            AddArtPiece addArtPieceView = new AddArtPiece();
//            addArtPieceView.setVisible(true);
//        }
    }
}

