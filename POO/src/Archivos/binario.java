
package Archivos;

import ejercicio10.Persona;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class binario {
    
    private void escribirBinario(){
        try {
            // creacion de archivo binario
            FileOutputStream archivo = new FileOutputStream("persona.bin");
            
            // Escribir archivo a partir del objeto Stream
            ObjectOutputStream escritura = new ObjectOutputStream(archivo);
            
            PersonaBinaria persona1 = new PersonaBinaria("Davis", 24);
            PersonaBinaria persona2 = new PersonaBinaria("Mariai",30);
            PersonaBinaria persona3 = new PersonaBinaria("Dav", 10);
            
            // escribimos objetos sobre el archivo binario
            escritura.writeObject(persona1);
            escritura.writeObject(persona2);
            escritura.writeObject(persona3);
            
            escritura.close(); // cerramos archivo binario
            
        } catch (FileNotFoundException ex) {
            System.err.println("Error : " + ex);
        } catch (IOException ex) {
                Logger.getLogger(binario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    private void leerBinario(){
        PersonaBinaria objetoPersona;
        try {
            FileInputStream archivo = new FileInputStream("persona.bin");
            ObjectInputStream lectura = new ObjectInputStream(archivo); 
            while(true){
                // recorremos el archivo binario
                
                objetoPersona = (PersonaBinaria) lectura.readObject();
                
                System.out.println(objetoPersona.toString());
            }
        }catch(EOFException ex){
            return ; // Finalizo de leer todo el archivo binario
        }
        catch (FileNotFoundException ex) {
            System.err.println(" Error : " + ex);
        }catch (IOException ex) {
                Logger.getLogger(binario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
                    Logger.getLogger(binario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void anadirBinario(){
        try {
            // creacion de archivo binario
            FileOutputStream archivo = new FileOutputStream("persona.bin", true );
            
            // Escribir archivo a partir del objeto Stream
            AddContenido escritura = new AddContenido(archivo);
            
            PersonaBinaria persona1 = new PersonaBinaria("Juan", 18);
            PersonaBinaria persona2 = new PersonaBinaria("Luz",24);
            
            
            // escribimos objetos sobre el archivo binario
            escritura.writeObject(persona1);
            escritura.writeObject(persona2);
          
            
            escritura.close(); // cerramos archivo binario
            
        } catch (FileNotFoundException ex) {
            System.err.println("Error : " + ex);
        } catch (IOException ex) {
                Logger.getLogger(binario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void main(String[] args){
        binario arch = new binario();
        arch.escribirBinario();
        arch.anadirBinario();
       
        arch.leerBinario();
    }
}
