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
 * @author julian
 */
public class AgendarVehiculoGestion {
    private static final String GET_Agendas = "SELECT * FROM agendarvehiculo";
    private static final String GET_Agenda = "SELECT * FROM agendarvehiculo where id=? ";
    private static final String INSERT_Agenda = "insert into agendarvehiculo(idAgente,numCita,fecha,hora,descripcion) VALUES (?,?,?,?,?)";
    private static final String UPDATE_Agenda = "update agendarvehiculo set idAgente=?, numCita=?,fecha=?,hora=?,descripcion=? where id=?";
    private static final String DELETE_Agenda = "delete from agendarvehiculo where idAgenda=?";
    
     public static ArrayList<AgendarVehiculo> getAgendarVehiculos(){
        ArrayList<AgendarVehiculo> lista_agendas = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_Agendas);
            ResultSet result = sentencia.executeQuery();
            
            while (result!=null && result.next()) {
                lista_agendas.add(new AgendarVehiculo(
                        result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getDate(4),
                        result.getDouble(5),
                        result.getString (6)    ));
                
            }
        } catch (SQLException e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return lista_agendas;
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
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
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
               Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
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
               Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
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
                    Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null,e);
                }
                
                return false;
            }
    
}