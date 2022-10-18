package Polimorfismo;

public class VehiculoDeportivo extends Vehiculo{
    private int cilindrada;

    public VehiculoDeportivo(String matricula, String marca, String modelo, int cilindrada) {
        super(matricula,marca,modelo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String mostrarDatos(){
        return String.format("Matricula : %s \n Marca : %s \n Modelo : %s \n Cilindrada : %s ", getMatricula(), getMarca(), getModelo(), getCilindrada());
    }
}
