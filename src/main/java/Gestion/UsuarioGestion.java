package Gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Usuario;
import Model.Conexion;

/**
 *
 * @author Daniel
 */
public class UsuarioGestion {
    
    //Variables encargadas de llamar a la Base de Datos Usuario
    private static final String SQL_GETUSUARIOS="SELECT * FROM usuario";
    private static final String SQL_GETUSUARIO="SELECT * FROM usuario where id=? and idUsuario=?";
    private static final String SQL_INSERTUSUARIOS="INSERT into usuario(idUsuario, numCompra, nombre, apellido1, apellido2, correo, clave) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATEUSUARIOS="UPDATE usuario set numCompra=?, nombre=?, apellido1=?, apellido2=?, correo=?, clave=? where id=? and idUsuario=?";
    private static final String SQL_DELETEUSUARIOS="DELETE FROM usuario where id=? and idUsuario=?";
    
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
    
    //Metodo encargado de llamar a un Usuario
    public static Usuario getUsuario(int id, String idUsuario) {
        Usuario usuario = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_GETUSUARIO);
            sentencia.setInt(1, id);
            sentencia.setString(2, idUsuario);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                usuario = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return usuario;
    }//Fin metodo llamar un Usuario
    
    //Metodo encargado de realizar un INSERT en Usuario
    public static boolean insertUsuario(Usuario usuario) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_INSERTUSUARIOS);
            sentencia.setString(1, usuario.getIdUsuario());
            sentencia.setInt(2, usuario.getNumCompra());
            sentencia.setString(3, usuario.getNombre());
            sentencia.setString(4, usuario.getApellido1());
            sentencia.setString(5, usuario.getApellido2());
            sentencia.setString(6, usuario.getCorreo());
            sentencia.setString(7, usuario.getClave());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }//Fin metodo encargado de el INSERT
    
    //Metodo encargado de realizar un Update en Usuario
    public static boolean updateUsuario(Usuario usuario) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_UPDATEUSUARIOS);
            sentencia.setInt(1, usuario.getNumCompra());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getApellido1());
            sentencia.setString(4, usuario.getApellido2());
            sentencia.setString(5, usuario.getCorreo());
            sentencia.setString(6, usuario.getClave());
            sentencia.setInt(7, usuario.getId());
            sentencia.setString(8, usuario.getIdUsuario());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }//Fin metodo encargado de el Update
    
    //Metodo encargado de realizar un DELETE en Usuario
    public static boolean deleteUsuario(Usuario usuario) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETEUSUARIOS);
            sentencia.setInt(1, usuario.getId());
            sentencia.setString(2, usuario.getIdUsuario());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }//Fin metodo encargado de el DELETE
}//Fin clase
