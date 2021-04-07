package Model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovagomez
 */
public class Conexion {
    
    private static Conexion conexion;
    private static final String DBURL = "jdbc:mysql://localhost:3306/proyecto?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static Connection conn = null;
    
    private Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn=DriverManager.getConnection(DBURL, "proyecto", "proyecto_2021");
            
        } catch (ClassNotFoundException | SQLException
                | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
            
        }
    }
    
    public static synchronized Connection getConexion(){
        if(conexion==null){
            conexion=new Conexion();
        }
        
        return conn;
    }
    
}
