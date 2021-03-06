package Gestion;

import Model.Conexion;
import Model.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author yovagomez
 */
public class FacturaGestion {
    private static final String GET_FACTURAS = "SELECT * FROM factura";
    private static final String GET_FACTURA = "SELECT * FROM factura where id=? and idUsuario=?";
    private static final String INSERT_FACTURA = "INSERT INTO factura(idUsuario,idAgente,idVehiculo,fechaEntrega,total,descripcion)VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_FACTURA = "update factura set fec_hor=?, total=?, descripcion=? where id=? and idUsuario=?";
    private static final String DELETE_FACTURA = "delete from factura where id=? and idUsuario=?";
    
    
    public static ArrayList<Factura> getFacturas(){
        ArrayList<Factura> lista_facturas = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_FACTURAS);
            ResultSet result = sentencia.executeQuery();
            
            while (result!=null && result.next()) {
                lista_facturas.add(new Factura(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getDate(5),
                        result.getDouble(6),
                        result.getString(7)));
                
            }
        } catch (SQLException e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return lista_facturas;
    }
    
       public static Factura getFactura(int id, String idUsuario){
        Factura factura=null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_FACTURA);
            sentencia.setInt(1, id);
            sentencia.setString(1, idUsuario);
            ResultSet result = sentencia.executeQuery();
            
            while (result!=null && result.next()) {
                factura=new Factura(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getDate(5),
                        result.getDouble(6),
                        result.getString(7));
                
            }
        } catch (SQLException e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return factura;
    }
       
       public static boolean insertFactura (Factura factura){
           try {
               PreparedStatement sentencia=Conexion.getConexion().prepareStatement(INSERT_FACTURA);
               sentencia.setString(1, factura.getIdUsuario());
               sentencia.setString(2, factura.getIdAgente());
               sentencia.setInt(3, factura.getIdVehiculo());
               sentencia.setObject(4, factura.getFec_hor());
               sentencia.setDouble(5, factura.getTotal());
               sentencia.setString(6, factura.getDescripcion());
               return sentencia.executeUpdate() > 0;
           } catch (SQLException e) {
               Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
           }
           return false;
       }
       
            public static boolean updateFactura (Factura factura){
           try {
               PreparedStatement sentencia=Conexion.getConexion().prepareStatement(UPDATE_FACTURA);
               sentencia.setString(1, factura.getIdUsuario());
               sentencia.setString(2, factura.getIdAgente());
               sentencia.setInt(3, factura.getIdVehiculo());
               sentencia.setObject(4, factura.getFec_hor());
               sentencia.setDouble(5, factura.getTotal());
               sentencia.setString(6, factura.getDescripcion());
               sentencia.setInt(7, factura.getId());
               
               return sentencia.executeUpdate() > 0;
               
           } catch (SQLException e) {
               Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE,null,e);
           }
           
           return false;
       }
            
            public static boolean deleteFactura (Factura factura){
                try {
                    PreparedStatement sentencia=Conexion.getConexion().prepareStatement(DELETE_FACTURA);
                    sentencia.setInt(1, factura.getId());
                    sentencia.setString(2, factura.getIdUsuario());
                    
                    return sentencia.executeUpdate() > 0;
                    
                } catch (SQLException e) {
                    Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null,e);
                }
                
                return false;
            }
            
        
}

