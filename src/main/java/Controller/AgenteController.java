package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Model.Agente;
import Gestion.AgenteGestion;

/**
 *
 * @author Daniel
 */
@Named(value = "agenteController")
@SessionScoped
public class AgenteController extends Agente implements Serializable {

    /**
     * Función de este CDI Bean: Metodos encargados encargados de traer los
     * parametros para mostrarlos en el HTML de la pagina web.
     */
    //Constructor default
    public AgenteController() {
    }//Fin constructor default

    //Metodo encargado de traer a todos los Agentes
    public List<Agente> getAgentes() {
        return AgenteGestion.getAgentes();
    }//Fin metodo de traer los agentes

    //Metodo encargado de traer solo un Agente
    public String traerAgente(int id, String idAgente) {
        Agente elAgente = AgenteGestion.getAgente(id, idAgente);
        if (elAgente != null) {
            this.setId(elAgente.getId());
            this.setIdAgente(elAgente.getIdAgente());
            this.setNombre(elAgente.getNombre());
            this.setApellido1(elAgente.getApellido1());
            this.setApellido2(elAgente.getApellido2());
            this.setFechaNaci(elAgente.getFechaNaci());
            this.setCorreo(elAgente.getCorreo());
            this.setTel(elAgente.getTel());
            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("traerAgenteForm:identificacion", msg);
            return "list.xhtml";
        }
    }//Fin metodo de traer un agente

    //Metodo encargado del INSERT en Agente
    public String insertAgente() {
        if (AgenteGestion.insertAgente(this)) {
            return "Pla-Empleados.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al insertar un nuevo empleado");
            FacesContext.getCurrentInstance().addMessage("traerAgenteForm:identificacion", msg);
            return "Añdr-Emp.xhtml";
        }
    }//Fin metodo encargado del INSERT
    
    //Metodo encargado del Update en Agente
    public String updateAgente() {
        if (AgenteGestion.updateAgente(this)) {
            return "Pla-Empleados.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al modificar el empleado");
            FacesContext.getCurrentInstance().addMessage("traerAgenteForm:identificacion", msg);
            return "Añdr-Emp.xhtml";
        }
    }//Fin Metodo encargado del Update
    
    //Metodo encargado del Delete en Agente
    public String deleteAgente() {
        if (AgenteGestion.deleteAgente(this)) {
            return "Pla-Empleados.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al eliminar el empleado");
            FacesContext.getCurrentInstance().addMessage("traerAgenteForm:identificacion", msg);
            return "Pla-Empleados.xhtml";
        }
    }//Fin metodo encargado del DELETE
}//Fin clase 
