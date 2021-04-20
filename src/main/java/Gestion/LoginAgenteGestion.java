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

    private static final String SQL_GETLOGINAGENTE = "SELECT * FROM loginagente where usuario=? and password=MD5(?)";

    public static LoginAgente getLoginAgente(String usuario, String password) {
        LoginAgente loginAgente = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETLOGINAGENTE);
            sentencia.setString(1, usuario);
            sentencia.setString(2, password);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                loginAgente = new LoginAgente();
                loginAgente.setUsuario(usuario);
                loginAgente.setPassword(password);
                loginAgente.setNombre(rs.getString(3));
                loginAgente.setIdRol(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginAgenteGestion.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Esta picha no sirve");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", mensage);
        }
        return loginAgente;
    }
}
