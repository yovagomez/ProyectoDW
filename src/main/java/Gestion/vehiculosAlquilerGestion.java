/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Model.Conexion;
import Model.Tiquete;
import Model.vehiculosAlquiler;
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
public class vehiculosAlquilerGestion {
    
    private static final String GET_ALQUILERES = "SELECT * FROM vehiculosalquiler";
    private static final String GET_ALQUILER = "SELECT * FROM vehiculosalquiler where id=? and idVehiculo=?";
    private static final String INSERT_ALQUILER = "insert into vehiculosalquiler(idVehiculo,placa,marca,modelo,color,anio,respaldo) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_ALQUILER = "update vehiculosalquiler set marca=?, modelo=?, color=?, anio=?, respaldo=?, where id=? and idVehiculo=?";
    private static final String DELETE_ALQUILER = "delete from vehiculosalquiler where id=? and idVehiculo=?";

    public static ArrayList<vehiculosAlquiler> getAlquileres() {
        ArrayList<vehiculosAlquiler> lista_Alquileres = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_ALQUILERES);
            ResultSet result = sentencia.executeQuery();

            while (result != null && result.next()) {
                lista_Alquileres.add(new vehiculosAlquiler(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getInt(7),
                        result.getString(8)));

            }
        } catch (Exception e) {
            Logger.getLogger(vehiculosAlquilerGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return lista_Alquileres;
    }
    
    public static vehiculosAlquiler getAlquiler(int id, int idVehiculo) {
        vehiculosAlquiler vehiculos = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(GET_ALQUILER);
            sentencia.setInt(1, id);
            sentencia.setInt(2, idVehiculo);
            ResultSet result = sentencia.executeQuery();
            while (result != null && result.next()) {
                vehiculos = new vehiculosAlquiler(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getInt(7),
                        result.getString(8));
            }

        } catch (SQLException ex) {
            Logger.getLogger(vehiculosAlquilerGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }
    
     public static boolean insertAlquiler(vehiculosAlquiler vehiculos) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(INSERT_ALQUILER);
            sentencia.setInt(1, vehiculos.getIdVehiculo());
            sentencia.setString(2, vehiculos.getPlaca());
            sentencia.setString(3, vehiculos.getMarca());
            sentencia.setString(4, vehiculos.getModelo());
            sentencia.setString(5, vehiculos.getColor());
            sentencia.setInt(6, vehiculos.getAnio());
            sentencia.setString(7,vehiculos.getRespaldo());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(vehiculosAlquilerGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    public static boolean updateAlquiler(vehiculosAlquiler vehiculos) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(UPDATE_ALQUILER);
            sentencia.setInt(1, vehiculos.getIdVehiculo());
            sentencia.setString(2, vehiculos.getPlaca());
            sentencia.setString(3, vehiculos.getMarca());
            sentencia.setString(4, vehiculos.getModelo());
            sentencia.setString(5, vehiculos.getColor());
            sentencia.setInt(6, vehiculos.getAnio());
            sentencia.setString(7, vehiculos.getRespaldo());
            sentencia.setInt(8, vehiculos.getId());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(vehiculosAlquilerGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public static boolean deleteAlquiler(vehiculosAlquiler vehiculos) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(DELETE_ALQUILER);
            sentencia.setInt(1, vehiculos.getId());
            sentencia.setInt(2, vehiculos.getIdVehiculo());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            Logger.getLogger(vehiculosAlquilerGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
}
