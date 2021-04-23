package Controller;

import Model.Conexion;
import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author yovagomez
 */
@Named(value = "reporteController")
@SessionScoped
public class reporteController implements Serializable {

    public reporteController() {
    }
    
    public void verFactura() {
        try {
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Factura/factura.jasper"));
            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(), null, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException | IOException e) {
            Logger.getLogger(reporteController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void facturaPDF() {
        try {
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Factura/factura.jasper"));
            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(),null, Conexion.getConexion());
            HttpServletResponse respuesta=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            respuesta.setContentType("application.pdf");
            respuesta.addHeader("Content-disposition", "attachment; filename=reporteLista.pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (JRException | IOException e) {
            Logger.getLogger(reporteController.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
       public void verTiquete() {
        try {
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Tiquete/tiquete.jasper"));
            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(), null, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException | IOException e) {
            Logger.getLogger(reporteController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
       
         public void tiquetePDF() {
        try {
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Tiquete/tiquete.jasper"));
            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(),null, Conexion.getConexion());
            HttpServletResponse respuesta=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            respuesta.setContentType("application.pdf");
            respuesta.addHeader("Content-disposition", "attachment; filename=reporteLista.pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (JRException | IOException e) {
            Logger.getLogger(reporteController.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}

