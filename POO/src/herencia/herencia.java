package herencia;
/*
* Es una forma de reutilización de software en la que se crea una nueva clase al absorber los miembros de una ya existente
*
* # Clase Padre -- Super Clase
* # Clase Hija -- Sub Clase
* */
public class herencia {
    public static void main(String[] args){
        Estudiante estudiante = new Estudiante("davis","berrios",24, 1, 6);

        estudiante.mostrarDatos();
    }
}
