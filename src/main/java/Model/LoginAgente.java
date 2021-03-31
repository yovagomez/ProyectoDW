package Model;

/**
 *
 * @author yovagomez
 */
public class LoginAgente {
    private String usuario;
    private String password;
    private String nombre;
    
   public LoginAgente () {
       
   }
   
   public LoginAgente(String usuario, String password, String nombre){
       this.usuario=usuario;
       this.password=password;
       this.nombre=nombre;
   }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
