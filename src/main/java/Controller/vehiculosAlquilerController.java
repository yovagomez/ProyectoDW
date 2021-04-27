/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gestion.vehiculosAlquilerGestion;
import Gestion.vehiculosVentaGestion;
import Model.vehiculosAlquiler;
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
@Named(value = "vehiculosAlquilerController")
@SessionScoped
public class vehiculosAlquilerController extends vehiculosAlquiler implements Serializable {

    public vehiculosAlquilerController() {
    }

    public List<vehiculosAlquiler> getVehiculos() {
        return vehiculosAlquilerGestion.getAlquileres();
    }

    public String traerAlquiler(int id, int idVehiculo) {
        vehiculosAlquiler elAlquiler = vehiculosAlquilerGestion.getAlquiler(id, idVehiculo);
        if (elAlquiler != null) {
            this.setId(elAlquiler.getId());
            this.setIdVehiculo(elAlquiler.getIdVehiculo());
            this.setPlaca(elAlquiler.getPlaca());
            this.setMarca(elAlquiler.getMarca());
            this.setModelo(elAlquiler.getModelo());
            this.setColor(elAlquiler.getColor());
            this.setAnio(elAlquiler.getAnio());
            this.setRespaldo(elAlquiler.getRespaldo());

            return "vehiculosAlquilerClient.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "ListaAlquiler.xhtml";
        }
    }

    public String insertAlquiler() {
        if (vehiculosAlquilerGestion.insertAlquiler(this)) {
            return "ListaAlquiler.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "AñadirAlquiler.xhtml";
        }
    }

    public String updateAlquiler() {
        if (vehiculosAlquilerGestion.updateAlquiler(this)) {
            return "ListaAlquiler.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "vehiculosAlquilerClient.xhtml";
        }
    }

    public String deleteAlquiler() {
        if (vehiculosAlquilerGestion.deleteAlquiler(this)) {
            return "ListaAlquiler.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error, vuelva a intentarlo");
            FacesContext.getCurrentInstance().addMessage("traerAlquilerForm:identificacion", mensaje);
            return "vehiculosAlquilerClient.xhtml";
        }
    }

    public void respaldoVA() {
        ZipOutputStream out = null;
        try {
            String json = vehiculosAlquilerGestion.respaldoVA();
            File f = new File(FacesContext.getCurrentInstance().
                    getExternalContext().getRealPath("/respaldo") + "vehiculosalquiler.zip");
            out = new ZipOutputStream(new FileOutputStream(f));
            ZipEntry e = new ZipEntry("vehiuclosalquiler.json");
            out.putNextEntry(e);
            byte[] data = json.getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();
            out.close();
            File zipPath = new File(FacesContext.getCurrentInstance().
                    getExternalContext().getRealPath("/respaldo") + "vehiculosalquiler.zip");
            byte[] zip = Files.readAllBytes(zipPath.toPath());

            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-disposition", "attachment; filename=vehiuclosalquiler.zip");
            ServletOutputStream flujo = respuesta.getOutputStream();
            flujo.write(zip);
            flujo.flush();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(vehiculosAlquilerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(vehiculosAlquilerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(vehiculosAlquilerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
