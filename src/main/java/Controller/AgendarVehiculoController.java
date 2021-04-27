/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author USUARIO
 */
@Named(value = "agendarVehiculoController")
@SessionScoped
public class AgendarVehiculoController extends AgendarVehiculo implements Serializable {

    /**
     * Creates a new instance of AgendarVehiculoController
     */
    public AgendarVehiculoController() {
    }
    
     public List<AgendarVehiculo> getAgendas() {
        return AgendarVehiculoGestion.getAgendas();
    }
    
      public String insertAgenda() {
        if (AgendarVehiculoGestion.insertAgenda(this)){
            return "ListaAgendas.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al insertar un nuevo empleado");
            FacesContext.getCurrentInstance().addMessage("traerAgendarVehiculoForm:identificacion", msg);
            return "agendarVehiculo.xhtml";
        }
    }
}
