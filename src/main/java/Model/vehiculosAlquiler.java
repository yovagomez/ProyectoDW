/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class vehiculosAlquiler {
    private int id; 
    private int idVehiculo;
    private String placa; 
    private String marca; 
    private String modelo; 
    private String color; 
    private int anio; 
    private String respaldo; 

    public vehiculosAlquiler() {
    }

    public vehiculosAlquiler(int id, int idVehiculo, String placa, String marca, String modelo, String color, int anio, String respaldo) {
        this.id = id;
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.respaldo = respaldo;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getRespaldo() {
        return respaldo;
    }

    public void setRespaldo(String respaldo) {
        this.respaldo = respaldo;
    }
    
    
    
}
