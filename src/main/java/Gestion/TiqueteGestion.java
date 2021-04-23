package Gestion;

import Model.Conexion;
import Model.Factura;
import Model.Tiquete;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovagomez
 */
public class TiqueteGestion {

    private static final String GET_TIQUETES = "SELECT * FROM tiquete";
    private static final String GET_TIQUETE = "SELECT * FROM tiquete where id=? and idUsuario=?";
    private static final String INSERT_TIQUETE = "insert into tiquete(idUsuario,idAgente,idVehiculo,fechaEntrega,horaEntrega,fechaDevolucion,horaDevolucion,total,descripcion) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_TIQUETE = "update tiquete set fechaEntrega=?,horaEntrega=?,fechaDevolucion=?,horaDevolucion=?, total=?, descripcion=? where id=? and idUsuario=?";
    private static final String DELETE_TIQUETE = "delete from tiquete where id=? and idUsuario=?";

    public static ArrayList<Tiquete> getTiquetes() {
        ArrayList<Tiquete> lista_tiquetes = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_TIQUETES);
            ResultSet result = sentencia.executeQuery();

            while (result != null && result.next()) {
                lista_tiquetes.add(new Tiquete(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getDate(5),
                        result.getTime(6),
                        result.getDate(7),
                        result.getTime(8),
                        result.getDouble(9),
                        result.getString(10)));

            }
        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return lista_tiquetes;
    }

    public static Tiquete getTiquete(int id, String idUsuario) {
        Tiquete tiquete = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_TIQUETE);
            sentencia.setInt(1, id);
            sentencia.setString(2, idUsuario);
            ResultSet result = sentencia.executeQuery();

            while (result != null && result.next()) {
                tiquete = new Tiquete(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getDate(5),
                        result.getTime(6),
                        result.getDate(7),
                        result.getTime(8),
                        result.getDouble(9),
                        result.getString(10));

            }
        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return tiquete;
    }

    public static boolean insertTiquete(Tiquete tiquete) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(INSERT_TIQUETE);
            sentencia.setString(1, tiquete.getIdUsuario());
            sentencia.setString(2, tiquete.getIdAgente());
            sentencia.setInt(3, tiquete.getIdVehiculo());
            sentencia.setObject(4, tiquete.getFechaEntrega());
            sentencia.setObject(4, tiquete.getHoraEntrega());
            sentencia.setObject(4, tiquete.getFechaDevolucion());
            sentencia.setObject(4, tiquete.getHoraDevolucion());
            sentencia.setDouble(5, tiquete.getTotal());
            sentencia.setString(6, tiquete.getDescripcion());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public static boolean updateTiquete(Tiquete tiquete) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(UPDATE_TIQUETE);
            sentencia.setString(1, tiquete.getIdUsuario());
            sentencia.setString(2, tiquete.getIdAgente());
            sentencia.setInt(3, tiquete.getIdVehiculo());
            sentencia.setObject(4, tiquete.getFechaEntrega());
            sentencia.setObject(4, tiquete.getHoraEntrega());
            sentencia.setObject(4, tiquete.getFechaDevolucion());
            sentencia.setObject(4, tiquete.getFechaDevolucion());
            sentencia.setDouble(5, tiquete.getTotal());
            sentencia.setString(6, tiquete.getDescripcion());
            sentencia.setInt(7, tiquete.getId());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public static boolean deleteTiquete(Tiquete tiquete) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(DELETE_TIQUETE);
            sentencia.setInt(1, tiquete.getId());
            sentencia.setString(2, tiquete.getIdUsuario());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

}
