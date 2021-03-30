/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gestion.DescuentoGestion;
import Model.Descuento;
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
@Named(value = "descuentoController")
@Dependent
public class DescuentoController extends Descuento implements Serializable {

    /**
     * Creates a new instance of DescuentoController
     */
    public DescuentoController() {
    }
    public List<Descuento> getDescuentos(){
        return DescuentoGestion.getDescuentos();
    }
    public String EditaDescuento (int id, String idDescuento) {
        Descuento elDescuento = DescuentoGestion.getDescuento(id, idDescuento);
        if (elDescuento != null) {
            this.setId(elDescuento.getId());
            this.setIdDescuento(elDescuento.getIdDescuento());
            this.setDescuento(elDescuento.getDescuento());
            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage (FacesMessage.SEVERITY_ERROR, "Error", "Posiblemente el dato no exista");
            FacesContext.getCurrentInstance().addMessage("TraerDescuentoForm:identificacion", msg);
            return "list.xhtml";
        }
    } //fin metodo traer descuento
    public String insertDescuento(){
        if (DescuentoGestion.insertDescuento(this)) {
            return "list.xhtml";
        }else {
            FacesMessage msg = new FacesMessage (FacesMessage.SEVERITY_ERROR, "Error","Error al insertar el nuevo descuento");
            FacesContext.getCurrentInstance().addMessage("traerDescuentoForm:identificacion", msg);
            return "edita.xhtml";
        }
    }
    public String updateDescuento(){
        if (DescuentoGestion.updateDescuento(this)){
            return "list.xhtml";
        }else {
            FacesMessage msg = new FacesMessage (FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar el estudiante");
            FacesContext.getCurrentInstance().addMessage("traerAgenteForm:identificacion", msg);
            return "edita.xhtml";
        }
    }
    public String deleteDescuento(){
        if (DescuentoGestion.DeleteDescuento(this)){
            return "list.xhtml";
        }else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al eliminar el estudiante");
            FacesContext.getCurrentInstance().addMessage("traerDescuentoForm:identificacion", msg);
            return "edita.xhtml";
        }
    }
    
    
}
