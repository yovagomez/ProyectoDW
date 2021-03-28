/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ASUS
 */
public class vehiculosVenta {

    private int id; 
    private int idVehiculo; 
    private String marca; 
    private String modelo; 
    private String color; 
    private int anio; 
    private String respaldo; 

    public vehiculosVenta() {
    }

    public vehiculosVenta(int id, int idVehiculo, String marca, String modelo, String color, int anio, String respaldo) {
        this.id = id;
        this.idVehiculo = idVehiculo;
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
