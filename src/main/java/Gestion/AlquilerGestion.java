/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Model.Alquiler;
import Model.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaac Ureña
 */
public class AlquilerGestion {
    private static final String GET_ALQUILERES="SELECT * FROM alquiler";
    private static final String GET_ALQUILER="SELECT * FROM alquiler where codigoAlquiler=? and idUsuario=?";
    private static final String INSERT_ALQUILER="INSERT into alquiler (codigoAlquiler,idUsuario,idVehiculo,idAgente,fechaEntrega,horaEntrega,fechaDevolucion,horaDevolucion,montoAlquiler) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_ALQUILER="UPDATE alquiler set fechaEntrega=?, horaEntrega=?, fechaDevolucion=?, horaDevolucion=?, montoAlquiler=? where codigoAlquiler=? and idUsuario=?";
    private static final String DELETE_ALQUILER="DELETE FROM alquiler where codigoAlquiler=? and idUsuario=?";
    
    public static ArrayList<Alquiler> getAlquileres() {
        ArrayList<Alquiler> registro_Alquiler = new ArrayList<>();
        try{
            PreparedStatement lista = Conexion.getConexion().prepareStatement(GET_ALQUILERES);
            ResultSet result = lista.executeQuery();
            
            while (result !=null && result.next()){
                registro_Alquiler.add(new Alquiler(
                result.getInt(1),
                result.getString(2),
                result.getInt(3),
                result.getInt(4),
                result.getDate(5),
                result.getString(6),
                result.getDate(7),
                result.getTime(8),
                result.getDouble(9)));
            }
                    } catch (SQLException ex){
                        Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        return registro_Alquiler;
    }
   public  static Alquiler getAlquiler(int codigoAlquiler, String idUsuario){
       Alquiler alquiler = null;
       try{
           PreparedStatement lista = Conexion.getConexion().prepareStatement(GET_ALQUILER);
           lista.setInt(1, codigoAlquiler);
           lista.setString(2, idUsuario);
           ResultSet result = lista.executeQuery();
           
           while (result != null && result.next()){
               alquiler = new Alquiler(
               result.getInt(1),
               result.getString(2),
               result.getInt(3),
               result.getInt(4),
               result.getDate(5),
               result.getString(6),
               result.getDate(7),
               result.getTime(8),
               result.getDouble(9));
           }
       }catch (SQLException ex){
           Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
       }
       return alquiler;
   }
   public static boolean insertAlquiler(Alquiler alquiler){
       try{
           PreparedStatement lista = Conexion.getConexion().prepareStatement(INSERT_ALQUILER);
           lista.setString(1, alquiler.getIdUsuario());
           lista.setInt(2, alquiler.getIdVehiculo());
           lista.setInt(3, alquiler.getIdAgente());
           lista.setDate(4, alquiler.getFechaEntrega());
           lista.setString(5, alquiler.getHoraEntrega());
           lista.setDate(6, alquiler.getFechaDevolucion());
           lista.setTime(7, alquiler.getHoraDevolucion());
           lista.setDouble(8, alquiler.getMontoAlquiler());
           return lista.executeUpdate() > 0;
   
       } catch (SQLException ex){
           Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
   }
   public static boolean updateAlquiler(Alquiler alquiler) {
       try {
           PreparedStatement lista = Conexion.getConexion().prepareStatement(UPDATE_ALQUILER);
           lista.setString(1, alquiler.getIdUsuario());
           lista.setInt(2, alquiler.getIdVehiculo());
           lista.setInt(3, alquiler.getIdAgente());
           lista.setDate(4, alquiler.getFechaEntrega());
           lista.setString(5, alquiler.getHoraEntrega());
           lista.setDate(6, alquiler.getFechaDevolucion());
           lista.setTime(7, alquiler.getHoraDevolucion());
           lista.setDouble(8, alquiler.getMontoAlquiler());
           
           return lista.executeUpdate() > 0;
       } catch (SQLException ex){
           Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
   }
   public static boolean deleteAlquiler(Alquiler alquiler) {
       try {
           PreparedStatement lista = Conexion.getConexion().prepareStatement(DELETE_ALQUILER);
           lista.setInt(1, alquiler.getCodigoAlquiler());
           lista.setString(2, alquiler.getIdUsuario());
           
           return lista.executeUpdate() > 0;
           
       } catch (SQLException ex) {
           Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
   }
}
