/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Gestion.vehiculosVentaGestion;
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
@Named(value = "chartBarView")
@SessionScoped
public class ChartBarView implements Serializable {

    private BarChartModel barModel;

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    private void createBarModels() {
        createBarModel();
    }
    
    ArrayList<ventasPorMarca> datos = vehiculosVentaGestion.getVentasPorMarca();
        int mayor = datos.get(0).getTotal();

    private void createBarModel() {
        barModel=new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Marcas");
         for (ventasPorMarca linea : datos) {
                 boys.set(linea.getMarca(), linea.getTotal());
            }



        barModel.addSeries(boys);


        barModel.setTitle("Estadisticas de Ventas");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Marcas");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

}
