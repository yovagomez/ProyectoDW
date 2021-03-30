/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Isaac Ureña
 */
public class Alquiler {
    private int codigoAlquiler;
    private String idUsuario;
    private int idVehiculo;
    private int idAgente ;
    private Date fechaEntrega;
    private String horaEntrega;
    private Date fechaDevolucion;
    private Time horaDevolucion;
    private double montoAlquiler;

    public Alquiler() {
    }

    public Alquiler(int codigoAlquiler, String idUsuario, int idVehiculo, int idAgente, Date fechaEntrega, String horaEntrega, Date fechaDevolucion, Time horaDevolucion, double montoAlquiler) {
        this.codigoAlquiler = codigoAlquiler;
        this.idUsuario = idUsuario;
        this.idVehiculo = idVehiculo;
        this.idAgente = idAgente;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.montoAlquiler = montoAlquiler;
    }

    public int getCodigoAlquiler() {
        return codigoAlquiler;
    }

    public void setCodigoAlquiler(int codigoAlquiler) {
        this.codigoAlquiler = codigoAlquiler;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Time getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Time horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(double montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }

    
}
