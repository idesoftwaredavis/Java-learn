package ejercicio10;

public class Entrenador extends Persona{
    private String estrategi;

    public Entrenador(String nombre, String apellidos, int edad, String estrategi) {
        super(nombre, apellidos, edad);
        this.estrategi = estrategi;
    }

    public String getEstrategi() {
        return estrategi;
    }

    @Override
    public void partidoFutbol(){
        System.out.println("Dirige un partido de futbol");
    }

    @Override
    public void entrenamiento(){
        System.out.println("Digige un entrenamiento");
    }

    public void planificarEntrenamiento(){
        System.out.println("Planificando entrenamiento");
    }
}
