package Controller;

import Gestion.FacturaGestion;
import Model.Factura;
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
@Named(value = "facturaController")
@SessionScoped
public class FacturaController extends Factura implements Serializable {

    /**
     * Creates a new instance of FacturaController
     */
    public FacturaController() {
    }
    
    public List<Factura> getFacturas(){
        return FacturaGestion.getFacturas();
    }
    
    public String editaFactura (int id, String idUsuario) {
        Factura laFactura = FacturaGestion.getFactura(id, idUsuario);
        if (laFactura!=null) {
            this.setId(laFactura.getId());
            this.setIdUsuario(laFactura.getIdUsuario());
            this.setIdAgente(laFactura.getIdAgente());
            this.setIdVehiculo(laFactura.getIdVehiculo());
            this.setFec_hor(laFactura.getFec_hor());
            this.setTotal(laFactura.getTotal());
            this.setDescripcion(laFactura.getDescripcion());
            
            return "edita.xhtml";
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaFacturaForm:identificacion", mensaje);
            return "lista.xhtml";
        }
    }
    
    public String insertFactura() {
        if (FacturaGestion.insertFactura(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaFacturaForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        
    public String updateFactura() {
        if (FacturaGestion.updateFactura(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaFacturaForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        public String deleteFactura() {
        if (FacturaGestion.deleteFactura(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaFacturaForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
}
