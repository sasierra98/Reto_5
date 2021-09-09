package access;

import java.util.ArrayList;
import model.pilotosModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import utils.ConnectionDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class pilotosDAO {

    //CONEXION A LA BASE DE DATOS

    private Connection conn = null;

    public ArrayList<pilotosModel> getAllPilotos(){
        ArrayList<pilotosModel> pilotos = new ArrayList();
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT pi.codigoPiloto, pi.nombre, pi.millasRecorridas, pi.combustibleUsado, es.codigo_escuderia FROM piloto pi JOIN escuderia es ON " +
                    "es.codigo_escuderia = pi.codigo_escuderia_fk";
                    ;

                    //"es.nombre, es.patrocinador "
                    //+
                    //"FROM piloto pi JOIN escuderia es "
                    //+ "ON pi.codigo_escuderia_fk = es.codigo_escuderia";
            Statement statament = conn.createStatement();
            ResultSet result = statament.executeQuery(sql);  //error statement
            while(result.next()){
                pilotosModel piloto = new pilotosModel(result.getInt(1),result.getString(2), result.getFloat(3), result.getInt(4), result.getInt(5));
                pilotos.add(piloto);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return pilotos;
    }

    public ArrayList<pilotosModel> getPiloto(int codigoPiloto){
//        pilotosModel piloto = null;
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT nombre FROM piloto WHERE codigo_piloto = 872;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigoPiloto);
            ResultSet result = statement.executeQuery(sql);

            //tengo error en el WHILE

//            while (result.next()) {
//                piloto = new pilotoModel(codigoPiloto, result.getInt(1));
//                break;
//            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return null;
    }

    public void agregarPiloto(pilotosModel piloto){
        try{
            if (conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO piloto(codigo_piloto, nombre , millas_recorridas ,combustible_usado ,codigo_escuderia_fk)"
                    + "VALUES(?, ?, ?, ?, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,piloto.getCodigoPiloto());
            statement.setString(2,piloto.getNombre());
            statement.setFloat(3,piloto.getMillasRecorridas());
            statement.setInt(4,piloto.getCombustibleUsado());
            statement.setInt(5,piloto.getCodigoEscuderia_fk());
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

    public void actualizaPiloto(pilotosModel piloto){

        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "UPDATE piloto SET millas_recorridas = 124009.2 WHERE codigo_piloto = 872;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setFloat(1, piloto.getMillasRecorridas());
            statement.setInt(4, piloto.getCodigoPiloto());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        }

        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void eliminarPiloto(int codigoPiloto){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "DELETE FROM piloto WHERE codigo_piloto=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigoPiloto);
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