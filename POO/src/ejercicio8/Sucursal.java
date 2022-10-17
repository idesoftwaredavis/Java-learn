
package ejercicio8;


public class Sucursal {
    private int numeroSucursal;
    private String direccion;
    private String ciudad;

    public Sucursal(int _numeroSucursal, String _direccion, String _ciudad) {
        this.numeroSucursal = _numeroSucursal;
        this.direccion = _direccion;
        this.ciudad = _ciudad;
    }

    public int getNumeroSucursal() {
        return numeroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String mostrarDatosSucursal() {
      return String.format("Numero Sucursal : %s \n - Direccion : %s \n - Ciudad %s \n ");
    };



    public double calcular_precio(Paquete p){

        double precioFinal = 0;
        // Se cobra de inmediato el precio por kilo
        precioFinal = 1 * p.getPeso();
        if(p.getPrioridad() == 1){
            precioFinal+= 10;
        }else if (p.getPrioridad() == 2){
            precioFinal+=20;
        }

        return precioFinal;
    }

}
