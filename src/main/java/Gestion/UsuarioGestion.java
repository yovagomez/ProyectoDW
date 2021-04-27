package Gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Usuario;
import Model.Conexion;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

/**
 *
 * @author Daniel
 */
public class UsuarioGestion {
    
    //Variable encargada de llamar a la Base de Datos Usuario
    private static final String SQL_GETUSUARIOS="SELECT * FROM usuario";
    
    //Metodo encargado de llamar a todos los Usuarios
    public static ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_GETUSUARIOS);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;
    }//Fin metodo de llamar todos los Usuarios
    
    //Metodo encargado de hacer el respaldo en Json 
    public static String respaldoUsuario() {
        Usuario respaldo = null;
        String tiraJson = "";
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_GETUSUARIOS);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                respaldo = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objetoJson = creadorJson.add("id", respaldo.getId())
                        .add("idUsuario", respaldo.getIdUsuario())
                        .add("numero_Compra", respaldo.getNumCompra())
                        .add("nombre", respaldo.getNombre())
                        .add("apellido1", respaldo.getApellido1())
                        .add("apellido2", respaldo.getApellido2())
                        .add("correo", respaldo.getCorreo())
                        .add("clave", respaldo.getClave())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objetoJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return tiraJson;
    }//Fin metodo de respaldo
}//Fin clase
