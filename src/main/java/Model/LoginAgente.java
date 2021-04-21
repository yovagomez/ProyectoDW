package Model;

/**
 *
 * @author yovagomez
 */
public class LoginAgente {
    
    private String usuario;
    private String clave;
    private String nombre;
    private String idRol;

    public LoginAgente() {
    }

    public LoginAgente(String usuario, String clave, String nombre, String idRol) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.idRol = idRol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
}//Fin clase
