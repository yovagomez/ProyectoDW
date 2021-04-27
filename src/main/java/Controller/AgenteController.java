package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Model.Agente;
import Gestion.AgenteGestion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

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
            return "Pla-Empleados.xhtml";
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

    /*Metodo encargado de mandar el parametro para la busqueda y 
    actualizacion de un empleado*/
    public String editaEmpleado(int id, String idAgente) {
        Agente elEmp = AgenteGestion.getAgente(id, idAgente);
        if (elEmp != null) {
            this.setId(elEmp.getId());
            this.setIdAgente(elEmp.getIdAgente());
            this.setNombre(elEmp.getNombre());
            this.setApellido1(elEmp.getApellido1());
            this.setApellido2(elEmp.getApellido2());
            this.setFechaNaci(elEmp.getFechaNaci());
            this.setCorreo(elEmp.getCorreo());
            this.setTel(elEmp.getTel());
            return "Actu-Emp.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:identificacion", msg);
            return "Pla-Empleados.xhtml";
        }
    }//Fin metodo de actualizar

    //Metodo respaldo
    public void respaldoAgente() {
        ZipOutputStream out = null;
        try {
            String json = AgenteGestion.respaldoJson();
            File f = new File(FacesContext.getCurrentInstance().
                    getExternalContext().getRealPath("/respaldo") + "agentes.zip");
            out = new ZipOutputStream(new FileOutputStream(f));
            ZipEntry e = new ZipEntry("agentes.json");
            out.putNextEntry(e);
            byte[] data = json.getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();
            out.close();
            File zipPath = new File(FacesContext.getCurrentInstance().
                    getExternalContext().getRealPath("/respaldo") + "agentes.zip");
            byte[] zip = Files.readAllBytes(zipPath.toPath());

            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-disposition", "attachment; filename=agentes.zip");
            ServletOutputStream flujo = respuesta.getOutputStream();
            flujo.write(zip);
            flujo.flush();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AgenteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AgenteController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(AgenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//Fin metodo respaldo   
}//Fin clase 
