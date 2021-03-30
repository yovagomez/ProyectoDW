/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gestion.AlquilerGestion;
import Model.Alquiler;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Isaac Ureña
 */
@Named(value = "alquilerController")
@Dependent
public class AlquilerController extends Alquiler implements Serializable {

    /**
     * Creates a new instance of AlquilerController
     */
    public AlquilerController() {
    }
    public List<Alquiler> getAlquiler(){
       return AlquilerGestion.getAlquileres();
    }
    public String editaAlquiler (int codigoAlquiler, String idUsuario) {
        Alquiler elAlquiler = AlquilerGestion.getAlquiler(codigoAlquiler, idUsuario);
        if (elAlquiler != null) {
            this.setCodigoAlquiler(elAlquiler.getCodigoAlquiler());
            this.setIdUsuario(elAlquiler.getIdUsuario());
            this.setIdVehiculo(elAlquiler.getIdVehiculo());
            this.setIdAgente(elAlquiler.getIdAgente());
            this.setFechaEntrega(elAlquiler.getFechaEntrega());
            this.setHoraEntrega(elAlquiler.getHoraEntrega());
            this.setFechaDevolucion(elAlquiler.getFechaDevolucion());
            this.setHoraDevolucion(elAlquiler.getHoraDevolucion());
            this.setMontoAlquiler(elAlquiler.getMontoAlquiler());
            return "lista.xhtml";
        } else {
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error intente de nuevo");
            FacesContext.getCurrentInstance().addMessage("editaAlquilerForm:identificacion", mensaje);
            return "lista.xhtml";
        }
    }
    public String insertAlquiler(){
        if (AlquilerGestion.insertAlquiler(this)) {
            return "lista.xhtml";
        }else {
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Error intente de nuevo");
            FacesContext.getCurrentInstance().addMessage("EditaAlquilerForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    public String updateAlquiler() {
        if (AlquilerGestion.updateAlquiler(this)){
            return "lista.xhtml";
        }else{
            FacesMessage mensaje=new FacesMessage (FacesMessage.SEVERITY_ERROR, "Error","Error intente de nuevo");
            FacesContext.getCurrentInstance().addMessage("EditaAlquilerForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    public String deleteAlquiler(){
        if (AlquilerGestion.deleteAlquiler(this)) {
            return "lista.xhtml";
        }else {
            FacesMessage mensaje =new FacesMessage (FacesMessage.SEVERITY_ERROR,"Error","Error intente de nuevo");
            FacesContext.getCurrentInstance().addMessage("editaAlquilerForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
}
