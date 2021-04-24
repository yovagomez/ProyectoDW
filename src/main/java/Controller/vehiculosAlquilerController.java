/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gestion.vehiculosAlquilerGestion;
import Model.vehiculosAlquiler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ASUS
 */
@Named(value = "vehiculosAlquilerController")
@SessionScoped
public class vehiculosAlquilerController extends vehiculosAlquiler implements Serializable {

   public vehiculosAlquilerController() {
    }
    
     public List<vehiculosAlquiler> getVehiculos(){
        return vehiculosAlquilerGestion.getAlquileres();
    }
    
    public String traerAlquiler (int id, int idVehiculo) {
        vehiculosAlquiler elAlquiler = vehiculosAlquilerGestion.getAlquiler(id, idVehiculo);
        if (elAlquiler!=null) {
            this.setId(elAlquiler.getId());
            this.setIdVehiculo(elAlquiler.getIdVehiculo());
            this.setPlaca(elAlquiler.getPlaca());
            this.setMarca(elAlquiler.getMarca());
            this.setModelo(elAlquiler.getModelo());
            this.setColor(elAlquiler.getColor());
            this.setAnio(elAlquiler.getAnio());
            this.setRespaldo(elAlquiler.getRespaldo());
            
            return "vehiculosAlquilerClient.xhtml";
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "ListaAlquiler.xhtml";
        }
    }
    
    public String insertAlquiler() {
        if (vehiculosAlquilerGestion.insertAlquiler(this)) {
            return "ListaAlquiler.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "AñadirAlquiler.xhtml";
        }
    }
    
        
    public String updateAlquiler() {
        if (vehiculosAlquilerGestion.updateAlquiler(this)) {
            return "ListaAlquiler.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "vehiculosAlquilerClient.xhtml";
        }
    }
    
        public String deleteAlquiler() {
        if (vehiculosAlquilerGestion.deleteAlquiler(this)) {
            return "ListaAlquiler.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "vehiculosAlquilerClient.xhtml";
        }
    }

}


