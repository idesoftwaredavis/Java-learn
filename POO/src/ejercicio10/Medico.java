package ejercicio10;

public class Medico extends Persona{

    private String titulacion;
    private int aniosExperiencia;

    public Medico(String nombre, String apellidos, int edad, String titulacion, int aniosExperiencia) {
        super(nombre, apellidos, edad);
        this.titulacion = titulacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    @Override
    public void partidoFutbol(){
        System.out.println("Da asistencia en un partido de futbol");
    }

    @Override
    public void entrenamiento(){
        System.out.println("Da asistencia en un entrenamiento");
    }

    public void curarLesion(){
        System.out.println("Curar lesion");
    }
}
