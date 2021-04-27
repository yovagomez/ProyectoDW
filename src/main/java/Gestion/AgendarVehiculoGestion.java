package Gestion;



import Model.AgendarVehiculo;
import Model.Agente;

import Model.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julian
 */
public class AgendarVehiculoGestion {
    private static final String GET_Agendas = "SELECT * FROM agendarVehiculo";
    private static final String GET_Agenda = "SELECT * FROM agendarVehiculo where id=? ";
    private static final String INSERT_Agenda = "INSERT INTO agendarVehiculo(idAgente,numCita,fecha,hora,descripcion) VALUES (?,?,?,?,?)";
    private static final String UPDATE_Agenda = "update agendarVehiculo set idAgente=?, numCita=?,fecha=?,hora=?,descripcion=? where id=?";
    private static final String DELETE_Agenda = "delete from agendarVehiculo where idAgenda=?";
    
       public static ArrayList<AgendarVehiculo> getAgendas() {
        ArrayList<AgendarVehiculo> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(GET_Agendas);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new AgendarVehiculo(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getDouble(5),
                        rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgendarVehiculoGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;
        }
        
     public static AgendarVehiculo getagendarVehiculo(int id , int numCita){
        AgendarVehiculo agenda=null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_Agenda);
            sentencia.setInt(1, id);
            sentencia.setInt(1, numCita);
            ResultSet result = sentencia.executeQuery();
            
            while (result!=null && result.next()) {
                agenda=new AgendarVehiculo(
                        result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getDate(4),
                        result.getDouble(5),
                        result.getString(6));
                
            }
        } catch (SQLException e) {
            Logger.getLogger(AgendarVehiculoGestion.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return agenda;
    }
     public static boolean insertAgenda(AgendarVehiculo agenda){
           try {
               PreparedStatement sentencia=Conexion.getConexion().prepareStatement(INSERT_Agenda);
               sentencia.setInt(1, agenda.getIdAgente());
               sentencia.setInt(2, agenda.getNumCita());
               sentencia.setObject(3, agenda.getFecha());
               sentencia.setDouble(4, agenda.getHora());
               sentencia.setString(5, agenda.getDescripcion());
               
               return sentencia.executeUpdate() > 0;
               
           } catch (SQLException e) {
               Logger.getLogger(AgendarVehiculoGestion.class.getName()).log(Level.SEVERE,null,e);
           }
           
           return false;
       }
      public static boolean updateAgenda(AgendarVehiculo agenda){
           try {
               PreparedStatement sentencia=Conexion.getConexion().prepareStatement(UPDATE_Agenda);
               sentencia.setInt(1, agenda.getIdAgente());
               sentencia.setInt(2, agenda.getNumCita());
               sentencia.setObject(3, agenda.getFecha());
               sentencia.setDouble(4, agenda.getHora());
               sentencia.setString(5, agenda.getDescripcion());
               
               return sentencia.executeUpdate() > 0;
               
           } catch (SQLException e) {
               Logger.getLogger(AgendarVehiculoGestion.class.getName()).log(Level.SEVERE,null,e);
           }
           
           return false;
       }
      public static boolean deleteAgenda (AgendarVehiculo agenda){
                try {
                    PreparedStatement sentencia=Conexion.getConexion().prepareStatement(DELETE_Agenda);
                    sentencia.setInt(1, agenda.getIdAgenda());
                    sentencia.setInt(2, agenda.getNumCita());
                    
                    return sentencia.executeUpdate() > 0;
                    
                } catch (SQLException e) {
                    Logger.getLogger(AgendarVehiculoGestion.class.getName()).log(Level.SEVERE, null,e);
                }
                
                return false;
            }
    
}