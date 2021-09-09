package view;

import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.pilotosModel;

public class ControlsPanel extends JPanel {

    private JLabel                       lblPiloto;
    private JComboBox<pilotosModel>       cbxPilotoList;
    private JLabel                       lblPresentations;
    //private JComboBox<PresentationModel> cbxPresentationsList;
    //  private JLabel                       lblName;
    //private JTextField                   txtName;
    private JButton                      btnSearch;
    private JButton                      btnAddArtPiece;
    private JTable                       tblResults;

    /**
     *
     * @param resultsPanel
     */

    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }


    /**
     *
     */
    private void initComponents(){
        setLayout(new GridLayout(2,1));
        InitialData initialData = new InitialData();

        // Complete ArtPieces info
        this.setTblResults(initialData.getPilotos());

        // Museum selection
        this.lblPiloto = new JLabel("Pilotos");
        add(this.getLblPiloto());

        this.cbxPilotoList = new JComboBox();
        this.cbxPilotoList.setModel(new DefaultComboBoxModel<>(initialData.getPilotos().toArray(new pilotosModel[initialData.getPilotos().size()])));
        this.cbxPilotoList.setSelectedIndex(0);
        add(this.getCbxPilotoList());

        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxPilotoList().addActionListener(changeEvent);


        // Exhibition selection
//        this.lblPresentations = new JLabel("Presentación");
//        add(this.getLblPresentations());
//
//        this.cbxPresentationsList = new JComboBox();
//        this.setCbxPresentationsList(initialData.getPresentations());
//        add(this.getCbxPresentationsList());


        // Name patttern
//        this.lblName = new JLabel("Nombre de la Obra");
//        add(this.getLblName());
//
//        this.txtName = new JTextField();
//        add(this.getTxtName());


        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);

        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);

        // Insert  button
        this.btnAddArtPiece = new JButton("Agregar Nueva Obra");
        add(this.getBtnAddArtPiece());
        this.getBtnAddArtPiece().addActionListener(clickEvent);
    }

    /**
     * @return the lblMuseums
     */
    public JLabel getLblPiloto() {
        return lblPiloto;
    }

    /**
     * @return the cbxMuseumsList
     */
    public JComboBox getCbxPilotoList() {
        return cbxPilotoList;
    }

    /**
     * @return the lblPresentations
     */
//    public JLabel getLblPresentations() {
//        return lblPresentations;
//    }

    /**
     * @return the cbxPresentationsList
     */
//    public JComboBox getCbxPresentationsList() {
//        return cbxPresentationsList;
//    }

    /**
     * @return the lblName
     */
//    public JLabel getLblName() {
//        return lblName;
//    }

    /**
     * @return the txtName
     */
//    public JTextField getTxtName() {
//        return txtName;
//    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

//    /**
//     * @param presentations
//     */
//    public void setCbxPresentationsList(ArrayList<PresentationModel> presentations) {
//        this.cbxPresentationsList.setModel(new DefaultComboBoxModel<>(presentations.toArray(new PresentationModel[presentations.size()])));
//        this.getCbxPresentationsList().setSelectedIndex(0);
//    }

//    /**
//     * @param artPieces
//     */

    public void setTblResults(ArrayList<pilotosModel> pilotoResults) {
        String[] headers = {"Piloto ID", "Nombre", "Millas Recorridas", "Combustible Usado", "Escuderia ID"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for(int i=0; i<pilotoResults.size(); i++){
            tableModel.addRow(pilotoResults.get(i).toArray() );
        }
    }

    /**
     * @return the btnAddArtPiece
     */
    public JButton getBtnAddArtPiece() {
        return btnAddArtPiece;
    }


}
