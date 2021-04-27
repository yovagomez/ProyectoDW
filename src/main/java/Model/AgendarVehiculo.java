
package Model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class AgendarVehiculo {
   private int id;
   private int idAgente;
   private int numCita;
   private Date fecha;
   private String hora;
   private String descripcion;

    public AgendarVehiculo() {
    }

    public AgendarVehiculo(int id, int idAgente, int numCita, Date fecha, String hora, String descripcion) {
        this.id = id;
        this.idAgente = idAgente;
        this.numCita = numCita;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
   
   
    
}
