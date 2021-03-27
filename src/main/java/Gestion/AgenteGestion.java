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
    
    //Variables encargadas de llamar la Base Datos
    private static final String SQL_GETAGENTES="SELECT * FROM agente";
    private static final String SQL_GETAGENTE="SELECT * FROM agente where id=? and idAgente=?";
    private static final String SQL_INSERTAGENTES="insert into agente(idAgente, nombre, apellido1, apellido2) VALUES (?,?,?,?)";
    private static final String SQL_UPDATEAGENTES="UPDATE agente set nombre=?, apellido1=?, apellido2=? where id=? and idAgente=?";
    private static final String SQL_DELETEAGENTES="DELETE FROM agente where id=? and idAgente=?";
    
    //Metodo encargado de llamar a todos los usuarios
    public static ArrayList<Agente> getAgente() {
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
    }//Fin metodo de llamar todos los usuarios
}//Fin clase
