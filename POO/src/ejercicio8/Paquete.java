package ejercicio8;


public class Paquete {
    private int numeroPaquete;
    private String dni;
    private double peso;
    private int prioridad;

    public Paquete(int _numeroPaquete, String _dni, double _peso, int _prioridad){
        numeroPaquete = _numeroPaquete;
        dni = _dni;
        peso = _peso;
        prioridad = _prioridad;
    }

    public int getNumeroPaquete() {
        return numeroPaquete;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String mostrarDatosPaquete(){
        return String.format("- Numero de paquete : %s \n - DNI : %s \n - Peso : %s \n - Prioridad : %s ", getNumeroPaquete(), getDni(), getPeso(), getPrioridad());
    }
}
