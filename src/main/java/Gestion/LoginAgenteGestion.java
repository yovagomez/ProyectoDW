package Gestion;

import Model.Conexion;
import Model.LoginAgente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author yovagomez
 */
public class LoginAgenteGestion {

    private static final String SQLGETLOGIN = "Select * from loginagente where usuario=? and clave=MD5(?)";

    public static LoginAgente getLoginAgente(String usuario, String clave) {
        LoginAgente login = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQLGETLOGIN);
            sentencia.setString(1, usuario);
            sentencia.setString(2, clave);
            ResultSet st = sentencia.executeQuery();

            if (st.next()) {
                login = new LoginAgente();
                login.setUsuario(usuario);
                login.setClave(clave);
                login.setNombre(st.getString(3));
                login.setIdRol(st.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginAgenteGestion.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Esta picha no sirve");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", mensage);
        }
        return login;
    }
}
