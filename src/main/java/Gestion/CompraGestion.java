package Gestion;

import Gestion.FacturaGestion;
import Gestion.FacturaGestion;
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
public class CompraGestion {

    private static final String GET_Compras = "SELECT * FROM compra";
    private static final String GET_Compra = "SELECT * FROM compra where id=? and codigoCompra=?";
    private static final String INSERT_Compra = "insert into compra(codigoCompra, idUsuario,idVehiculo, idAgente, idDescuento, montoCompra) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_Compra = "update compra set codigoCompra=?, idUsuario=?, idVehiculo=?, idAgente=?, idDescuento=?, montoCompra=? where id=? and idUsuario=?";
    private static final String DELETE_Compra = "delete from compra where id=? and idUsuario=?";

    public static ArrayList<Compra> getCompras() {
        ArrayList<Compra> lista_Compras = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_Compras);
            ResultSet result = sentencia.executeQuery();

            while (result != null && result.next()) {
                lista_Compras.add(new Compra(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getDouble(7)));

            }
        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return lista_Compras;
    }

    public static Compra getCompra(int id, int codigoCompra) {
        Compra compra = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_Compra);
            sentencia.setInt(1, id);
            sentencia.setInt(1, codigoCompra);
            ResultSet result = sentencia.executeQuery();

            while (result != null && result.next()) {
                compra = new Compra(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getDouble(7));

            }
        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return compra;
    }

    public static boolean insertCompra(Compra compra) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(INSERT_Compra);
            sentencia.setInt(1, compra.getId());
            sentencia.setInt(2, compra.getCodigoCompra());
            sentencia.setString(3, compra.getIdUsuario());
            sentencia.setInt(4, compra.getIdVehiculo());
            sentencia.setString(5, compra.getIdAgente());
            sentencia.setInt(6, compra.getIdDescuento());
            sentencia.setDouble(7, compra.getMontoCompra());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public static boolean updateCompra(Compra compra) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(UPDATE_Compra);
            sentencia.setInt(1, compra.getId());
            sentencia.setInt(2, compra.getCodigoCompra());
            sentencia.setString(3, compra.getIdUsuario());
            sentencia.setInt(4, compra.getIdVehiculo());
            sentencia.setString(5, compra.getIdAgente());
            sentencia.setInt(6, compra.getIdDescuento());
            sentencia.setDouble(7, compra.getMontoCompra());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public static boolean deleteCompra(Compra compra) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(DELETE_Compra);
            sentencia.setInt(1, compra.getId());
            sentencia.setString(2, compra.getIdUsuario());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

}
