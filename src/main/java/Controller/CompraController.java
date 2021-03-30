package Controller;

import Gestion.CompraGestion;
import Gestion.FacturaGestion;
import Model.Compra;
import Model.Factura;
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
@Named(value = "compraController")
@SessionScoped
public class CompraController extends Compra implements Serializable {

   
    public CompraController() {
    }
    public List<Compra> getCompras(){
        return CompraGestion.getCompras();
    }
    
    public String editaCompra (int id, int codigoCompra) {
        Compra laCompra = CompraGestion.getCompra(id, codigoCompra);
        if (laCompra!=null) {
            this.setId(laCompra.getId());
            this.setCodigoCompra(laCompra.getCodigoCompra());
            this.setIdUsuario(laCompra.getIdUsuario());
            this.setIdVehiculo(laCompra.getIdVehiculo());
            this.setIdAgente(laCompra.getIdAgente());
            this.setIdDescuento(laCompra.getIdDescuento());
            this.setMontoCompra(laCompra.getMontoCompra());
            
            return "edita.xhtml";
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaFacturaForm:identificacion", mensaje);
            return "lista.xhtml";
        }
    }
    
    public String insertCompra() {
        if (CompraGestion.insertCompra(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaCompraForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        
    public String updateCompra() {
        if (CompraGestion.updateCompra(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaCompraForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
        public String deleteCompra() {
        if (CompraGestion.deleteCompra(this)) {
            return "lista.xhtml";
            
        }else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("editaCompraForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
}
