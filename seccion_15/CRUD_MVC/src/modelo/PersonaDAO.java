
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PersonaDAO extends Conexion {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    public PersonaDAO (){
        con = obtenerConexion();
    }
    
    public boolean insertar(Persona p){
       try{
           ps = con.prepareStatement("insert into persona (nombre,domicilio,celular,correo_electronico,fecha_nacimiento,genero,clave) values (?,?,?,?,?,?,?)");
           ps.setString(1,p.getNombre());
           ps.setString(2,p.getDomicilio());
           ps.setString(3,p.getCelular());
           ps.setString(4,p.getCorreo());
           ps.setDate(5,p.getFecha());
           ps.setString(6, p.getGenero());
           ps.setString(7,p.getClave());
           
           int resultado = ps.executeUpdate();
           
           if(resultado > 0 ){
               return true;
           }else{
               return false;
           }
       }catch(Exception ex){
           System.err.println("Error : "+ ex);
           return false;
       }finally{
           try{
               con.close();
           }catch(Exception ex){
                System.err.println("Error : "+ ex);
            }
       }
                
    };
    
    public boolean obtenerPersona(Persona p){
       try{
           ps = con.prepareStatement("select * from persona where clave=?");
           ps.setString(1, p.getClave());
           rs = ps.executeQuery();
           
           if(rs.next()){
               p.setIdPersona(rs.getInt("idPersona"));
               p.setNombre(rs.getString("nombre"));
               p.setDomicilio(rs.getString("domicilio"));
               p.setCorreo(rs.getString("correo_electronico"));
               p.setFecha(rs.getDate("fecha_nacimiento"));
               p.setCelular(rs.getString("celular"));
               p.setGenero(rs.getString("genero"));
               p.setClave(rs.getString("clave"));
               
               return true;
           }
          
           return false;
       }catch(Exception ex){
           System.err.println("Error : "+ ex);
           
           return false;
       }finally{
           try{
             
           }catch(Exception ex){
                System.err.println("Error : "+ ex);
            }
       }        
    };
    
    public boolean modificar(Persona p){
       try{
           ps = con.prepareStatement("update persona set nombre=?, domicilio=?, celular=?, correo_electronico=?, fecha_nacimiento=?, genero=?, clave=? where idPersona=?");
           ps.setString(1,p.getNombre());
           ps.setString(2,p.getDomicilio());
           ps.setString(3,p.getCelular());
           ps.setString(4,p.getCorreo());
           ps.setDate(5,p.getFecha());
           ps.setString(6, p.getGenero());
           ps.setString(7,p.getClave());
           ps.setInt(8, p.getIdPersona());
           
           int resultado = ps.executeUpdate();
           
           if(resultado>0){
               return true;
           }else{
               return false;
           }
       }catch(Exception ex){
           System.err.println("Error : "+ ex);
           
           return false;
       }finally{
           try{
             
           }catch(Exception ex){
                System.err.println("Error : "+ ex);
            }
       }        
    };
    
    
    public boolean eliminar(Persona p){
       try{
           ps = con.prepareStatement("delete from persona where idPersona=?");
           ps.setInt(1, p.getIdPersona());
           
           int resultado = ps.executeUpdate();
           
           if(resultado>0){
               return true;
           }else{
               return false;
           }
       }catch(Exception ex){
           System.err.println("Error : "+ ex);
           
           return false;
       }finally{
           try{
             
           }catch(Exception ex){
                System.err.println("Error : "+ ex);
            }
       }        
    };
}
