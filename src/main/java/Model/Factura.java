package Model;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author yovagomez
 */
public class Factura {
    private int id;
    private String idUsuario;
    private String idAgente;
    private int idVehiculo;
    private Timestamp fec_hor;
    private double total;
    private String descripcion;
    
    public Factura(){
    }
    
    public Factura(int id,String idUsuario,String idAgente,int idVehiculo,Timestamp fec_hor,double total,String descripcion){
        this.id=id;
        this.idUsuario=idUsuario;
        this.idAgente=idAgente;
        this.idVehiculo=idVehiculo;
        this.fec_hor=fec_hor;
        this.total=total;
        this.descripcion=descripcion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Timestamp getFec_hor() {
        return fec_hor;
    }

    public void setFec_hor(Timestamp fec_hor) {
        this.fec_hor = fec_hor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //Metodo toString devuelve un Json
    //Metodo Override: se utilizan cuando hay herencias, abstraccion y se sobreescribe para utilizarlo en otros metodos
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fecha1 = format.format(this.fec_hor);
        return "{\"Factura\":{\n\"Fecha Entrega\":\"" + fecha1 + "\"\n}\n}";
    }
    
}
