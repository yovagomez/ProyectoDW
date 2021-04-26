/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Gestion.vehiculosAlquilerGestion;
import Gestion.vehiculosVentaGestion;
import Model.AlquilerPorMarca;
import Model.ventasPorMarca;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author wmolina
 */
@Named(value = "chartBarView2")
@SessionScoped
public class ChartBarView2 implements Serializable {

    private BarChartModel barModel2;

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public BarChartModel getBarModel2() {
        return barModel2;
    }

    private void createBarModels() {
        createBarModel();
    }
    
    ArrayList<AlquilerPorMarca> datos = vehiculosAlquilerGestion.getAlquileresPorMarca();
        int mayor = datos.get(0).getTotal();

    private void createBarModel() {
        barModel2=new BarChartModel();
        ChartSeries alquileres = new ChartSeries();
        alquileres.setLabel("Marcas");
         for (AlquilerPorMarca linea : datos) {
                 alquileres.set(linea.getMarca(), linea.getTotal());
            }



        barModel2.addSeries(alquileres);


        barModel2.setTitle("Estadisticas de Ventas");
        barModel2.setLegendPosition("ne");

        Axis xAxis = barModel2.getAxis(AxisType.X);
        xAxis.setLabel("Marcas");

        Axis yAxis = barModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

}
