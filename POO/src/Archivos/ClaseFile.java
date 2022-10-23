package Archivos;

import java.io.File;

public class ClaseFile {

    public static void main(String[] args){
        File file = new File("CarpetaPrueba");

        if(file.exists()){
            System.out.println("El archivo existe");
            System.out.println("Ruta Absoluta : " + file.getAbsolutePath());
            System.out.println("¿Es un archivo ? :" + file.isDirectory());
            System.out.println("Este archivo se puede leer ? : " + file.canRead());
        }else{
            System.out.println("El archivo no existe");
        }
    }
}
