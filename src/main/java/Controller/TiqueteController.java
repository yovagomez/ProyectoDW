package Controller;

import Gestion.TiqueteGestion;
import Model.Factura;
import Model.Tiquete;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author yovagomez
 */
@Named(value = "tiqueteController")
@SessionScoped
public class TiqueteController extends Tiquete implements Serializable {

    /**
     * Creates a new instance of TiqueteController
     */
    public TiqueteController() {
    }
    
    public List<Tiquete> getTiquetes(){
        return TiqueteGestion.getTiquetes();
    }
    
    public String editaTiquete (int id, String idUsuario) {
        Tiquete elTiquete = TiqueteGestion.getTiquete(id, idUsuario);
        if (elTiquete!=null) {
            this.setId(elTiquete.getId());
            this.setIdUsuario(elTiquete.getIdUsuario());
            this.setIdAgente(elTiquete.getIdAgente());
            this.setIdVehiculo(elTiquete.getIdVehiculo());
            this.setFechaEntrega(elTiquete.getFechaEntrega());
            this.setHoraEntrega(elTiquete.getHoraEntrega());
            this.setFechaDevolucion(elTiquete.getFechaDevolucion());
            this.setHoraDevolucion(elTiquete.getHoraDevolucion());
            this.setTotal(elTiquete.getTotal());
            this.setDescripcion(elTiquete.getDescripcion());
            
            return "agregar.xhtml";
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaTiqueteForm:identificacion", mensaje);
            return "tiquete.xhtml";
        }
    }
    
    public String insertTiquete() {
        if (TiqueteGestion.insertTiquete(this)) {
            return "tiquete.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaFacturaForm:identificacion", mensaje);
            return "agregar.xhtml";
        }
    }
    
        
    public String updateTiquete() {
        if (TiqueteGestion.updateTiquete(this)) {
            return "tiquete.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaFacturaForm:identificacion", mensaje);
            return "agregar.xhtml";
        }
    }
    
        public String deleteTiquete() {
        if (TiqueteGestion.deleteTiquete(this)) {
            return "tiquete.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaFacturaForm:identificacion", mensaje);
            return "agregar.xhtml";
        }
    }
    
}
