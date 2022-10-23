
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL=false";
    public static final String usuario = "root";
    public static final String password = "";
    
    public Connection obtenerConexion(){
        Connection conexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            // Establecer la conexion 
            conexion = (Connection) DriverManager.getConnection(URL, usuario,password);                
        }catch(Exception ex){
            System.err.println("Error : "+ ex);
        }
        return conexion;
    };
}
