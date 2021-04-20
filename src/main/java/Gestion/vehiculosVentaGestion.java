/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Model.Conexion;
import Model.vehiculosVenta;
import Model.ventasPorMarca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class vehiculosVentaGestion {
    
    private static final String GET_VENTAS = "SELECT * FROM vehiculosventa";
    private static final String GET_VENTA = "SELECT * FROM vehiculosventa where id=? and idVehiculo=?";
    private static final String INSERT_VENTA = "insert into vehiculosventa(idVehiculo,marca,modelo,color,anio,respaldo) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_VENTA = "update vehiculosventa set marca=?, modelo=?, color=?, anio=?, respaldo=?, where id=? and idVehiculo=?";
    private static final String DELETE_VENTA = "delete from vehiculosventa where id=? and idVehiculo=?";
    private static final String GET_MARCAS = "select marca, count(*) total from vehiculosVenta group by marca order by marca";
    public static ArrayList<vehiculosVenta> getVentas() {
        ArrayList<vehiculosVenta> lista_Ventas = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_VENTAS);
            ResultSet result = sentencia.executeQuery();

            while (result != null && result.next()) { 
                lista_Ventas.add(new vehiculosVenta(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7)));

            }
        } catch (Exception e) {
            Logger.getLogger(vehiculosVentaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return lista_Ventas;
    }
    
    
    public static ArrayList<ventasPorMarca> getVentasPorMarca() {
        ArrayList<ventasPorMarca> lista_Ventas = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_MARCAS);
            ResultSet result = sentencia.executeQuery();

            while (result != null && result.next()) { 
                lista_Ventas.add(new ventasPorMarca(
                        result.getString(1),
                        result.getInt(2)));

            }
        } catch (Exception e) {
            Logger.getLogger(vehiculosVentaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return lista_Ventas;
    }

    
    public static vehiculosVenta getVenta(int id, int idVehiculo) {
        vehiculosVenta vehiculos = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_VENTA);
            sentencia.setInt(1, id);
            sentencia.setInt(2, idVehiculo);
            ResultSet result = sentencia.executeQuery();
            while (result != null && result.next()) {
                vehiculos = new vehiculosVenta(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7));
            }

        } catch (SQLException ex) {
            Logger.getLogger(vehiculosVentaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }
    
     public static boolean insertVenta(vehiculosVenta vehiculos) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(INSERT_VENTA);
            sentencia.setInt(1, vehiculos.getIdVehiculo());
            sentencia.setString(2, vehiculos.getMarca());
            sentencia.setString(3, vehiculos.getModelo());
            sentencia.setString(4, vehiculos.getColor());
            sentencia.setInt(5, vehiculos.getAnio());
            sentencia.setString(6,vehiculos.getRespaldo());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(vehiculosVentaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    public static boolean updateVenta(vehiculosVenta vehiculos) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(UPDATE_VENTA);
            sentencia.setInt(1, vehiculos.getIdVehiculo());
            sentencia.setString(2, vehiculos.getMarca());
            sentencia.setString(3, vehiculos.getModelo());
            sentencia.setString(4, vehiculos.getColor());
            sentencia.setInt(5, vehiculos.getAnio());
            sentencia.setString(6, vehiculos.getRespaldo());
            sentencia.setInt(7, vehiculos.getId());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(vehiculosVentaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public static boolean deleteVenta(vehiculosVenta vehiculos) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(DELETE_VENTA);
            sentencia.setInt(1, vehiculos.getId());
            sentencia.setInt(2, vehiculos.getIdVehiculo());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(vehiculosVentaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
    
}
