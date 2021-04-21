package Controller;

import Gestion.LoginAgenteGestion;
import Model.LoginAgente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author yovagomez
 */
@Named(value = "loginAgenteController")
@SessionScoped
public class LoginAgenteController extends LoginAgente implements Serializable {

    public LoginAgenteController() {
    }

    public String getLoginAgente() {
        LoginAgente login = LoginAgenteGestion.getLoginAgente(this.getUsuario(), this.getClave());
        if (login != null) {
            this.setNombre(login.getNombre());
            this.setIdRol(login.getIdRol());
            return "inicio.xhtml";
        } else {
            FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña incorrecta, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", mensage);
            return "index.xhtml";
        }
    }
}
