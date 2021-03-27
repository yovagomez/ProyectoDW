package Model;

/**
 *
 * @author Daniel
 */
public class Usuario {
    
    //Variables
    private int id;
    private String idUsuario;
    private int numCompra;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private String clave;

    public Usuario() {
    }//Fin constructor vacio

    public Usuario(int id, String idUsuario, int numCompra, String nombre, String apellido1, String apellido2, String correo, String clave) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.numCompra = numCompra;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.clave = clave;
    }//Fin constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }  
}//Fin clase
