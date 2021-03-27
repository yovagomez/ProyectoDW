package Model;

/**
 *
 * @author Daniel
 */
public class Agente {
    
    //Variables
    private int id;
    private String idAgente;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Agente() {
    }//Fin constructor vacio

    public Agente(int id, String idAgente, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.idAgente = idAgente;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }//Fin constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
}//Fin clase
