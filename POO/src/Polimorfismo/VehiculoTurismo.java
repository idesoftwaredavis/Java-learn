package Polimorfismo;

public class VehiculoTurismo extends Vehiculo{
    private int numeroPuertas;

    public VehiculoTurismo(String matricula, String marca, String modelo, int numeroPuertas) {
        super( matricula, marca, modelo);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String mostrarDatos(){
        return String.format("Matricula : %s \n Marca : %s \n Modelo : %s \n num Puertas : %s ", getMatricula(), getMarca(), getModelo(), getNumeroPuertas());
    };
}
