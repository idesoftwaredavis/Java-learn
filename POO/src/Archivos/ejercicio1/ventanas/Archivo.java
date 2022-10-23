package Archivos.ejercicio1.ventanas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Archivo {
    private File archivo;
    
    public void crearArchivo(){
        try {
            archivo = new File("agendaContactos.txt");
            if(archivo.createNewFile()){
                // Archivo creado
            }
        } catch (IOException ex) {
            System.err.println("ERror : "+ ex);
        }
    }
    
    public void escribirTexto(Persona persona){
        
        try {
            // Para escribir, se utiliza el objeto FileWriter
            // El segundo parametro significa que se va agregar mas texto 
            // Se añadira texto en el , no sera de solo lectura.
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(persona.getNombre() + "%" + persona.getCorreo() + "%" + persona.getCelular() + "\r\n");
            escribir.close();
        } catch (IOException ex) {
            System.err.println("Error : " + ex);
        }
    }
}
