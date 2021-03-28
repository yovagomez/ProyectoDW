package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Model.Usuario;
import Gestion.UsuarioGestion;

/**
 *
 * @author Daniel
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    /**
     * Función de este CDI Bean: Metodos encargados encargados de traer los
     * parametros para mostrarlos en el HTML de la pagina web.
     */
    //Constructor default
    public UsuarioController() {
    }//Fin constructor default

    //Metodo encargado de traer a todos los Usuario
    public List<Usuario> getUsuarios() {
        return UsuarioGestion.getUsuarios();
    }//Fin metodo de traer los usuarios

    //Metodo encargado de traer solo un Usuario
    public String traerUsuario(int id, String idUsuario) {
        Usuario elUsuario = UsuarioGestion.getUsuario(id, idUsuario);
        if (elUsuario != null) {
            this.setId(elUsuario.getId());
            this.setIdUsuario(elUsuario.getIdUsuario());
            this.setNumCompra(elUsuario.getNumCompra());
            this.setNombre(elUsuario.getNombre());
            this.setApellido1(elUsuario.getApellido1());
            this.setApellido2(elUsuario.getApellido2());
            this.setCorreo(elUsuario.getCorreo());
            this.setClave(elUsuario.getClave());
            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("traerUsuarioForm:identificacion", msg);
            return "list.xhtml";
        }
    }//Fin metodo de traer un Usuario

    //Metodo encargado del INSERT en Usuario
    public String insertUsuario() {
        if (UsuarioGestion.insertUsuario(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al insertar un nuevo estudiante");
            FacesContext.getCurrentInstance().addMessage("traerUsuarioForm:identificacion", msg);
            return "edita.xhtml";
        }
    }//Fin metodo encargado del INSERT

    //Metodo encargado del Update en Usuario
    public String updateUsuario() {
        if (UsuarioGestion.updateUsuario(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al modificar el estudiante");
            FacesContext.getCurrentInstance().addMessage("traerUsuarioForm:identificacion", msg);
            return "edita.xhtml";
        }
    }//Fin Metodo encargado del Update

    //Metodo encargado del Delete en Usuario
    public String deleteUsuario() {
        if (UsuarioGestion.deleteUsuario(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al eliminar el estudiante");
            FacesContext.getCurrentInstance().addMessage("traerUsuarioForm:identificacion", msg);
            return "edita.xhtml";
        }
    }//Fin metodo encargado del DELETE
}//Fin clase
