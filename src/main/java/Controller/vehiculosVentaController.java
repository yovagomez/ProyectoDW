/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gestion.vehiculosVentaGestion;
import Model.vehiculosVenta;
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
@Named(value = "vehiculosVentaController")
@SessionScoped
public class vehiculosVentaController extends vehiculosVenta implements Serializable {

 public vehiculosVentaController() {
    }
    
     public List<vehiculosVenta> getVehiculos(){
        return vehiculosVentaGestion.getVentas();
    }
    
    public String traerVenta (int id, int idVehiculo) {
        vehiculosVenta laVenta = vehiculosVentaGestion.getVenta(id, idVehiculo);
        if (laVenta!=null) {
            this.setId(laVenta.getId());
            this.setIdVehiculo(laVenta.getIdVehiculo());
            this.setMarca(laVenta.getMarca());
            this.setModelo(laVenta.getModelo());
            this.setColor(laVenta.getColor());
            this.setAnio(laVenta.getAnio());
            this.setRespaldo(laVenta.getRespaldo());
            
            return "edita.xhtml";
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerVentaForm:identificacion", mensaje);
            return "lista.xhtml";
        }
    }
    
    public String insertVenta() {
        if (vehiculosVentaGestion.insertVenta(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerVentaForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        
    public String updateVenta() {
        if (vehiculosVentaGestion.updateVenta(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerVentaForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        public String deleteVenta() {
        if (vehiculosVentaGestion.deleteVenta(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerVentaForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }

}
