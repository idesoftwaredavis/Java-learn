package Archivos;

import java.io.*;

public class ArchivoDeTexto {
    File archivo;
    private void crearArchivo() {
        archivo = new File("prueba.txt");

        try {
            if(archivo.createNewFile()){
                System.out.println("El archivo se ha creado correctamente");
            }
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo");
        }
    }

    private void crearDirectorio(){
        archivo = new File("CarpetaDesdeJava");
            if(archivo.mkdir()){
                System.out.println("Se ha creado el directorio");
            }else{
                System.out.println("No se ha creado, hubo un error");
            }
    }

    private void escribirTexto(){
        try {
            FileWriter escribir = new FileWriter(archivo);
            escribir.write("TEXTO DE PRUEBA ! ");
            escribir.write(" \r\nTEXTO DE PRUEBA 2222! ");

            escribir.close();
        } catch (IOException e) {
            System.err.println("No se pudo escribir sobre el archivo");
        }
    }

    private void anadirTexto(){
        try {
            FileWriter escribir = new FileWriter(archivo,true);

            escribir.write(" \r\n ESTO VIENE DESDE EL METODO ANADIR TEXTO");

            escribir.close();
        } catch (IOException e) {
            System.err.println("No se pudo escribir sobre el archivo");
        }
    }

    private void leerTexto(){
        String cadena;

        try {
            // Objeto que lee un archivo
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);

            cadena = lectura.readLine();
            while(cadena != null){
                System.out.println(cadena);
                cadena = lectura.readLine();
            }


        } catch (FileNotFoundException e) {
            System.err.println("Error : " + e);
        }catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    public static void main(String[] args){
            ArchivoDeTexto archivos = new ArchivoDeTexto();
            archivos.crearArchivo();
            archivos.escribirTexto();
            archivos.anadirTexto();
             archivos.leerTexto();
            archivos.crearDirectorio();


    }
}
