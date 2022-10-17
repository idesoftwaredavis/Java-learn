package herencia;

public class Estudiante extends Persona{
    private int codigoEstudiante;
    private float notaFinal;

    public Estudiante(String nombre, String apellido, int edad, int codigoEstudiante, float notaFinal){
        super(nombre,apellido,edad);
        this.codigoEstudiante = codigoEstudiante;
        this.notaFinal = notaFinal;
    }

    public void mostrarDatos(){
        System.out.println("Mostrando los datos del estudiante");
        System.out.println("Nombre : " + nombre);
        System.out.println("Apellido : " + getApellido());
        System.out.println("Nota final : "+ notaFinal);
    }
}
