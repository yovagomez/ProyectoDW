package Model;

/**
 *
 * @author julian
 */
public class Compra {

    private int id;
    private int codigoCompra;
    private String idUsuario;
    private int idVehiculo;
    private String idAgente;
    private int idDescuento;
    private double montoCompra;

    public Compra() {
    }

    public Compra(int id, int codigoCompra, String idUsuario, int idVehiculo, String idAgente, int idDescuento, double montoCompra) {
        this.id = id;
        this.codigoCompra = codigoCompra;
        this.idUsuario = idUsuario;
        this.idVehiculo = idVehiculo;
        this.idAgente = idAgente;
        this.idDescuento = idDescuento;
        this.montoCompra = montoCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public void setMontoCompra(double montoCompra) {
        this.montoCompra = montoCompra;
    }
    

}