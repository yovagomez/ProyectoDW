package Gestion;

import Gestion.FacturaGestion;
import Gestion.FacturaGestion;
import Model.AgendarVehiculo;
import Model.Compra;
import Model.Conexion;
import Model.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private static final String INSERT_Agenda = "insert into agendarvehiculo(id,numCita,fecha,hora,descripcion,codigoCompra) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_Agenda = "update agendarvehiculo set numCita=?,fecha=?,hora=?,descripcion=?,codigoCompra=? where id=?";
    private static final String DELETE_Agenda = "delete from agendarvehiculo where id=?";
    
     public static ArrayList<AgendarVehiculo> getAgendarVehiculos(){
        ArrayList<AgendarVehiculo> lista_agendas = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_Agendas);
            ResultSet result = sentencia.executeQuery();
            
            while (result!=null && result.next()) {
                lista_agendas.add(new AgendarVehiculo(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString (5),
                        result.getInt(6)));
                
            }
        } catch (Exception e) {
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
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6));
                
            }
        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return agenda;
    }
     public static boolean insertAgenda(AgendarVehiculo agenda){
           try {
               PreparedStatement sentencia=Conexion.getConexion().prepareStatement(INSERT_Agenda);
               sentencia.setInt(1, agenda.getId());
               sentencia.setInt(2, agenda.getNumCita());
               sentencia.setString(3, agenda.getFecha());
               sentencia.setString(4, agenda.getHora());
               sentencia.setString(5, agenda.getDescripcion());
               sentencia.setInt(6, agenda.getCodigoCompra());
               
               return sentencia.executeUpdate() > 0;
               
           } catch (Exception e) {
               Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
           }
           
           return false;
       }
      public static boolean updateAgenda(AgendarVehiculo agenda){
           try {
               PreparedStatement sentencia=Conexion.getConexion().prepareStatement(UPDATE_Agenda);
               sentencia.setInt(1, agenda.getId());
               sentencia.setInt(2, agenda.getNumCita());
               sentencia.setString(3, agenda.getFecha());
               sentencia.setString(4, agenda.getHora());
               sentencia.setString(5, agenda.getDescripcion());
               sentencia.setInt(6, agenda.getCodigoCompra());
               
               return sentencia.executeUpdate() > 0;
               
           } catch (Exception e) {
               Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
           }
           
           return false;
       }
      public static boolean deleteAgenda (AgendarVehiculo agenda){
                try {
                    PreparedStatement sentencia=Conexion.getConexion().prepareStatement(DELETE_Agenda);
                    sentencia.setInt(1, agenda.getId());
                    sentencia.setInt(2, agenda.getNumCita());
                    
                    return sentencia.executeUpdate() > 0;
                    
                } catch (Exception e) {
                    Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null,e);
                }
                
                return false;
            }
    
}