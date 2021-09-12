package view;

import access.carrerasDAO;
import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.carrerasModel;

public class ControlsPanel extends JPanel{

    private JLabel lblCarrera;
    private JComboBox<carrerasModel> cbxCarreraList;
    private JButton btnSearch;
    private JButton btnAddCarrera;
    private JTable tblResults;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblCapacity;
    private JTextField txtCapacity;
    private JLabel lblCapability;
    private JTextField txtCapability;
    private JLabel lblDifficulty;
    private JTextField txtDifficulty;

    /**
     * @param resultsPanel
     */

    public ControlsPanel(ResultsPanel resultsPanel) {
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 1));
        InitialData initialData = new InitialData();

        // Complete ArtPieces info
        this.setTblResults(initialData.getCarreras());

        // Museum selection
        this.lblCarrera = new JLabel("Carreras");
        add(this.getLblCarrera());

        this.cbxCarreraList = new JComboBox();
        this.cbxCarreraList.setModel(new DefaultComboBoxModel<>(initialData.getCarreras().toArray(new carrerasModel[initialData.getCarreras().size()])));
        this.cbxCarreraList.setSelectedIndex(0);
        add(this.getCbxCarreraList());

        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxCarreraList().addActionListener(changeEvent);

        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);

        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);

        // Insert  button
        this.btnAddCarrera = new JButton("Agregar Nueva Carrera");
        add(this.getBtnAddCarrera());
        this.getBtnAddCarrera().addActionListener(clickEvent);
//        this.btnAddCarrera.addActionListener(this);

        this.lblName = new JLabel("Nombre de la Carrera");
        add(this.lblName);
        this.txtName = new JTextField();
        add(this.txtName);

        this.lblCapacity = new JLabel("Capacidad de la Carrera");
        add(this.lblCapacity);
        this.txtCapacity = new JTextField();
        add(this.txtCapacity);

        this.lblCapability = new JLabel("" + "Disposición de la Carrera");
        add(this.lblCapability);
        this.txtCapability = new JTextField();
        add(this.txtCapability);

        this.lblDifficulty = new JLabel("Dificultad de la Carrera");
        add(this.lblDifficulty);
        this.txtDifficulty = new JTextField();
        add(this.txtDifficulty);


    }

    public JLabel getLblCarrera() {
        return lblCarrera;
    }

    public JComboBox getCbxCarreraList() {
        return cbxCarreraList;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JTable getTblResults() {
        return tblResults;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtCapability() {
        return txtCapability;
    }

    public void setTxtCapability(JTextField txtCapability) {
        this.txtCapability = txtCapability;
    }

    public JTextField getTxtCapacity() {
        return txtCapacity;
    }

    public void setTxtCapacity(JTextField txtCapacity) {
        this.txtCapacity = txtCapacity;
    }

    public JLabel getLblCapacity() {
        return lblCapacity;
    }

    public void setTxtDifficulty(JTextField txtDifficulty) {
        this.txtDifficulty = txtDifficulty;
    }

    public JTextField getTxtDifficulty() {
        return txtDifficulty;
    }

    public void setTblResults(ArrayList<carrerasModel> carrerasResult) {
        String[] headers = {"Nombre", "Capacidad", "Bajo LLuvia", "Dificultad"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (int i = 0; i < carrerasResult.size(); i++) {
            tableModel.addRow(carrerasResult.get(i).toArray());
        }
    }

    public JButton getBtnAddCarrera() {
        return btnAddCarrera;
    }

}