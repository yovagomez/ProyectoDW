package Gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Conexion;
import Model.Agente;

/**
 *
 * @author Daniel
 */
public class AgenteGestion {
    
    //Variables encargadas de llamar la Base de Datos Agente
    private static final String SQL_GETAGENTES="SELECT * FROM agente";
    private static final String SQL_GETAGENTE="SELECT * FROM agente where id=? and idAgente=?";
    private static final String SQL_INSERTAGENTES="INSERT into agente(idAgente, nombre, apellido1, apellido2) VALUES (?,?,?,?)";
    private static final String SQL_UPDATEAGENTES="UPDATE agente set nombre=?, apellido1=?, apellido2=? where id=? and idAgente=?";
    private static final String SQL_DELETEAGENTES="DELETE FROM agente where id=? and idAgente=?";
    
    //Metodo encargado de llamar a todos los Agentes
    public static ArrayList<Agente> getAgentes() {
        ArrayList<Agente> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_GETAGENTES);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Agente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgenteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;
    }//Fin metodo de llamar todos los Agentes
    
    //Metodo encargado de llamar a un Agente
    public static Agente getAgente(int id, String idAgente) {
        Agente agente = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_GETAGENTE);
            sentencia.setInt(1, id);
            sentencia.setString(2, idAgente);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                agente = new Agente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgenteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return agente;
    }//Fin metodo llamar un Agente
    
    //Metodo encargado de realizar un INSERT en Agente
    public static boolean insertAgente(Agente agente) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_INSERTAGENTES);
            sentencia.setString(1, agente.getIdAgente());
            sentencia.setString(2, agente.getNombre());
            sentencia.setString(3, agente.getApellido1());
            sentencia.setString(4, agente.getApellido2());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AgenteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }//Fin metodo encargado de el INSERT
    
    //Metodo encargado de realizar un Update en Agente
    public static boolean updateAgente(Agente agente) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_UPDATEAGENTES);
            sentencia.setString(1, agente.getNombre());
            sentencia.setString(2, agente.getApellido1());
            sentencia.setString(3, agente.getApellido2());
            sentencia.setInt(4, agente.getId());
            sentencia.setString(5, agente.getIdAgente());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AgenteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }//Fin metodo encargado de el Update
    
    //Metodo encargado de realizar un DELETE en Agente
    public static boolean deleteAgente(Agente agente) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETEAGENTES);
            sentencia.setInt(1, agente.getId());
            sentencia.setString(2, agente.getIdAgente());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AgenteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }//Fin metodo encargado de el DELETE
}//Fin clase
