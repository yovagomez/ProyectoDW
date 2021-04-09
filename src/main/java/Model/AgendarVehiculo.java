package Model;

import java.util.Date;
import org.exolab.castor.types.DateTime;

/**
 *
 * @author julian
 */
public class AgendarVehiculo {

    private int id;
    private int numCita;
    private  Date fecha;
    private Double  hora;
    private String descripcion;
    private int codigoCompra;

    public AgendarVehiculo() {
    }

    public AgendarVehiculo(int id, int numCita, Date  fecha, Double  hora, String descripcion, int codigoCompra) {
        this.id = id;
        this.numCita = numCita;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.codigoCompra = codigoCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

}
