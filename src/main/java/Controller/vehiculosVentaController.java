/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gestion.vehiculosVentaGestion;
import Model.vehiculosVenta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@Named(value = "vehiculosVentaController")
@SessionScoped
public class vehiculosVentaController extends vehiculosVenta implements Serializable {

    public vehiculosVentaController() {
    }

    public List<vehiculosVenta> getVehiculos() {
        return vehiculosVentaGestion.getVentas();
    }

    public String traerVenta(int id, int idVehiculo) {
        vehiculosVenta laVenta = vehiculosVentaGestion.getVenta(id, idVehiculo);
        if (laVenta != null) {
            this.setId(laVenta.getId());
            this.setIdVehiculo(laVenta.getIdVehiculo());
            this.setMarca(laVenta.getMarca());
            this.setModelo(laVenta.getModelo());
            this.setColor(laVenta.getColor());
            this.setAnio(laVenta.getAnio());
            this.setRespaldo(laVenta.getRespaldo());

            return "vehiculosVentaClient.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerVentaForm:identificacion", mensaje);
            return "ListaVenta.xhtml";
        }
    }

    public String insertVenta() {
        if (vehiculosVentaGestion.insertVenta(this)) {
            return "ListaVenta.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerVentaForm:identificacion", mensaje);
            return "AñadirVenta.xhtml";
        }
    }

    public String updateVenta() {
        if (vehiculosVentaGestion.updateVenta(this)) {
            return "ListaVenta.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerVentaForm:identificacion", mensaje);
            return "vehiculosVentaClient.xhtml";
        }
    }

    public String deleteVenta() {
        if (vehiculosVentaGestion.deleteVenta(this)) {
            return "ListaVenta.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerVentaForm:identificacion", mensaje);
            return "vehiculosVentaClient.xhtml";
        }
    }

    public void respaldoVV() {
        ZipOutputStream out = null;
        try {
            String json = vehiculosVentaGestion.respaldoVV();
            File f = new File(FacesContext.getCurrentInstance().
                    getExternalContext().getRealPath("/respaldo") + "vehiculosventa.zip");
            out = new ZipOutputStream(new FileOutputStream(f));
            ZipEntry e = new ZipEntry("vehiuclosventa.json");
            out.putNextEntry(e);
            byte[] data = json.getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();
            out.close();
            File zipPath = new File(FacesContext.getCurrentInstance().
                    getExternalContext().getRealPath("/respaldo") + "vehiculosventa.zip");
            byte[] zip = Files.readAllBytes(zipPath.toPath());

            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-disposition", "attachment; filename=vehiuclosventa.zip");
            ServletOutputStream flujo = respuesta.getOutputStream();
            flujo.write(zip);
            flujo.flush();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(vehiculosVentaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(vehiculosVentaController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(vehiculosVentaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}//Fin clase
