package Model;

import java.util.Date;
import org.exolab.castor.types.DateTime;

/**
 *
 * @author julian
 */
public class AgendarVehiculo {
    private int idAgenda;
    private int idAgente;
    private int numCita;
    private  Date fecha;
    private Double  hora;
    private String descripcion;

    public AgendarVehiculo() {
    }

    public AgendarVehiculo(int idAgenda, int idAgente, int numCita, Date fecha, Double hora, String descripcion) {
        this.idAgenda = idAgenda;
        this.idAgente = idAgente;
        this.numCita = numCita;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;

    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

 

    public int getNumCita() {
        return numCita;
    }

    public void setNumCita(int numCita) {
        this.numCita = numCita;
    }

    public Date  getFecha() {
        return fecha;
    }

    public void setFecha(Date  fecha) {
        this.fecha = fecha;
    }

    public Double  getHora() {
        return hora;
    }

    public void setHora(Double hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
