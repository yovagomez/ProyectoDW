package Controller;

import Gestion.AgendarVehiculoGestion;
import Model.AgendarVehiculo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author julian
 */
@Named(value = "agendarVehiculoController")
@SessionScoped
public class AgendarVehiculoController extends AgendarVehiculo implements Serializable {

   
    public AgendarVehiculoController() {
    }
    public List<AgendarVehiculo> getAgendas(){
        return AgendarVehiculoGestion.getAgendarVehiculos();
    }
    
    public String editaAgenda (int id, int numCita) {
        AgendarVehiculo laAgenda = AgendarVehiculoGestion.getagendarVehiculo(id, numCita);
        if (laAgenda!=null) {
            this.setId(laAgenda.getId());
            this.setNumCita(laAgenda.getNumCita());
            this.setFecha(laAgenda.getFecha());
            this.setHora(laAgenda.getHora());
            this.setDescripcion(laAgenda.getDescripcion());
            this.setCodigoCompra(laAgenda.getCodigoCompra());
            
            return "edita.xhtml";
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaAgendaForm:identificacion", mensaje);
            return "lista.xhtml";
        }
    }
     public String insertAgenda() {
        if (AgendarVehiculoGestion.insertAgenda(this)) {
            return "index.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaAgendaForm:identificacion", mensaje);
            return "index.xhtml";
        }
    }
    
        
    public String updateAgenda() {
        if (AgendarVehiculoGestion.updateAgenda(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaAgendaForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        public String deleteAgenda() {
        if (AgendarVehiculoGestion.deleteAgenda(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaAgendaForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
}