package ejercicio10;

public class Futbolista extends Persona {
    private int dorsal;
    private String posicion;

    public Futbolista(String nombre, String apellidos, int edad, int dorsal, String posicion) {
        super(nombre, apellidos, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public void partidoFutbol(){
        System.out.println("Juega el partido de Futbol");
    }

    @Override
    public void entrenamiento(){
        System.out.println("Entrena");
    }

    public void entrevista(){
        System.out.println("Da una entrevista");
    }
}
