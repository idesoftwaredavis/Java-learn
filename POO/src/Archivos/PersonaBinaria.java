
package Archivos;

import java.io.Serializable;
// Serializable --> interface dond todos los objetos de clase persona
// Se convertiran en un flujo o secuencia de bites
// para ser guardados en el archivo  binario
public class PersonaBinaria implements Serializable {
    private String nombre;
    private int edad;

    public PersonaBinaria(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "PersonaBinaria{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
    
    
}
