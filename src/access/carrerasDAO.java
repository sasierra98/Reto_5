package access;

import java.util.ArrayList;

import model.carrerasModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import utils.ConnectionDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class carrerasDAO {

    //CONEXION A LA BASE DE DATOS

    private Connection conn = null;

    public ArrayList<carrerasModel> getAllCarreras(){
        ArrayList<carrerasModel> carreras = new ArrayList();

        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT ca.name, ca.capacity, ca.capability, ca.difficulty FROM carreras ca";
            Statement statament = conn.createStatement();
            ResultSet result = statament.executeQuery(sql);  //error statement
            while(result.next()){
                carrerasModel carrera = new carrerasModel(result.getString(1),result.getInt(2), result.getString(3), result.getFloat(4));
                carreras.add(carrera);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return carreras;
    }

    public carrerasModel getCarrera(){
        carrerasModel carreras = null;
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT name FROM piloto WHERE name = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            //statement.setString(1, "");
            ResultSet result = statement.executeQuery(sql);

            //tengo error en el WHILE

            while (result.next()) {
                carreras = new carrerasModel(result.getString(1));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        System.out.println(carreras);
        return carreras;
    }

    public void addCarrera(carrerasModel carrera){
        try{
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO carreras(name, capacity, capability, difficulty)"
                    + "VALUES(?, ?, ?, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,carrera.getName());
            statement.setInt(2,carrera.getCapacity());
            statement.setString(3,carrera.getCapability());
            statement.setFloat(4,carrera.getDifficulty());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0)
                System.out.println("Se inserto");
            else
                System.out.println("No funciono");
            conn.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void UpdateCarrera(carrerasModel carrera){

        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "UPDATE carrera SET capacity = 124009 WHERE name = 'Vitaguata';";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, carrera.getCapacity());
            statement.setString(4, carrera.getName());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        }

        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteCarrera(carrerasModel name){
        System.out.println("entre");
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "DELETE FROM carreras WHERE name=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name.getName());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }

    }

}
