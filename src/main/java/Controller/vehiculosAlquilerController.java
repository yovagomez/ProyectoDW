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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ASUS
 */
public class vehiculosAlquilerController extends vehiculosAlquiler implements Serializable{

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
            
            return "edita.xhtml";
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "lista.xhtml";
        }
    }
    
    public String insertAlquiler() {
        if (vehiculosAlquilerGestion.insertAlquiler(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        
    public String updateAlquiler() {
        if (vehiculosAlquilerGestion.updateAlquiler(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        public String deleteAlquiler() {
        if (vehiculosAlquilerGestion.deleteAlquiler(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }

}