/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Isaac Ureña
 */
public class Descuento {
     private int id;
    private String Condiciones;
    private String descuento;
    
    public Descuento() {
    }

    public Descuento(int id, String Condiciones, String descuento) {
        this.id = id;
        this.Condiciones = Condiciones;
        this.descuento = descuento;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondiciones() {
        return Condiciones;
    }

    public void setCondiciones(String Condiciones) {
        this.Condiciones = Condiciones;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
 
}
