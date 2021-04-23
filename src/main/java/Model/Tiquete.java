package Model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import org.exolab.castor.types.DateTime;

/**
 *
 * @author yovagomez
 */
public class Tiquete {
    private int id;
    private String idUsuario;
    private String idAgente;
    private int idVehiculo;
    private Date fechaEntrega;
    private Time horaEntrega;
    private Date fechaDevolucion;
    private Time horaDevolucion;
    private double total;
    private String descripcion;

    public Tiquete() {

    }
    
    public Tiquete(int id,String idUsuario,String idAgente,int idVehiculo,Date fechaEntrega,Time horaEntrega,Date fechaDevolucion,Time horaDevolucion,double total,String descripcion){
        this.id=id;
        this.idUsuario=idUsuario;
        this.idAgente=idAgente;
        this.idVehiculo=idVehiculo;
        this.fechaEntrega=fechaEntrega;
        this.horaEntrega=horaEntrega;
        this.fechaDevolucion=fechaDevolucion;
        this.total=total;
        this.descripcion=descripcion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
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
}
