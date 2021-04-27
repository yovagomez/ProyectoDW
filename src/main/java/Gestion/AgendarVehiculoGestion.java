/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;


import Model.AgendarVehiculo;
import Model.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class AgendarVehiculoGestion {
    private static final String SQL_GETAGENDAS = "SELECT * FROM agendarVehiculo";
    private static final String SQL_GETAGENDA = "SELECT * FROM agendarVehiculo where id=? and idAgente=?";
    private static final String SQL_INSERTAGENDAS = "INSERT INTO agendarVehiculo(idAgente, numCita, fecha, hora, descripcion) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATEAGENDAS = "UPDATE agendarVehiculo set idAgente=?, numCita=?, fecha=?, hora=?, descripciom=? where id=? and idAgente=?";
    private static final String SQL_DELETEAGENDAS = "DELETE FROM agendarVehiculo where id=? and idAgente=?";

    
    public static ArrayList<AgendarVehiculo> getAgendas() {
        ArrayList<AgendarVehiculo> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_GETAGENDAS);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new AgendarVehiculo(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgendarVehiculoGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static boolean insertAgenda(AgendarVehiculo agenda) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_INSERTAGENDAS);
            sentencia.setInt(1, agenda.getIdAgente());
            sentencia.setInt(2, agenda.getNumCita());
            sentencia.setObject(3, agenda.getFecha());
            sentencia.setString(4, agenda.getHora());
            sentencia.setString(5, agenda.getDescripcion());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AgendarVehiculoGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
