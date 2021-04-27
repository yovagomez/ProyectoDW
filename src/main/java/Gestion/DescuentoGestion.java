/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Model.Conexion;
import Model.Descuento;
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
public class DescuentoGestion {
    private static final String GET_DESCUENTOS ="SELECT * FROM descuento";
    private static final String GET_DESCUENTO ="SELECT * FROM descuento where id=? and condiciones=?";
    private static final String INSERT_DESCUENTO ="INSERT into descuento (id,condiciones,descuento) VALUES (?,?,?)";
    private static final String UPDATE_DESCUENTO ="UPDATE descuento set descuento=? where condiciones=? and id=?";
    private static final String DELETE_DESCUENTO ="DELETE FROM descuento where id=? and condiciones=?";
    
        public static ArrayList<Descuento> getDescuentos() {
            ArrayList<Descuento> registro_Descuento = new ArrayList<>();
            try {
                PreparedStatement tira = Conexion.getConexion().prepareStatement(GET_DESCUENTOS);
                ResultSet result = tira.executeQuery();
                
               while (result !=null && result.next()){
                   registro_Descuento.add(new Descuento(
                   result.getInt(1),
                   result.getString (2),
                   result.getString(3)));
                           
               }
               
            } catch (Exception e){
                Logger.getLogger(DescuentoGestion.class.getName()).log(Level.SEVERE, null, e);
            }
           return registro_Descuento;
        }
        
        public static Descuento getDescuento(int id, String Descuento){
            Descuento descuento = null;
            try {
                PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_DESCUENTO);
                sentencia.setInt(1, id);
                sentencia.setString(2, Descuento);
                ResultSet rs = sentencia.executeQuery();
                
                while (rs != null && rs.next()) {
                    descuento=new Descuento(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
                }
            } catch (SQLException ex){
                Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return descuento;
        }
        public static boolean insertarDescuento(Descuento descuento){
            try {
                PreparedStatement sentencia = Conexion.getConexion().prepareStatement(INSERT_DESCUENTO);
                sentencia.setString(1, descuento.getDescuento());
                sentencia.setString(2, descuento.getCondiciones());
                return sentencia.executeUpdate() > 0;
            } catch (SQLException ex){
                Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
        public static boolean modificarDescuento(Descuento descuento) {
            try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(UPDATE_DESCUENTO);
            sentencia.setInt(1, descuento.getId());
            sentencia.setString(2, descuento.getDescuento());
            sentencia.setString(3, descuento.getCondiciones());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex){
           Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
}
        public static boolean EliminarDescuento (Descuento descuento) {
            try {
                PreparedStatement sentencia = Conexion.getConexion().prepareStatement(DELETE_DESCUENTO);
                sentencia.setInt(1, descuento.getId());
                sentencia.setString(2, descuento.getDescuento());
                return sentencia.executeUpdate() > 0;
            }catch (SQLException ex) {
                Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }       
}
   