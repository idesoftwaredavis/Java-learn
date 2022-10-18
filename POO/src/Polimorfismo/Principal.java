package Polimorfismo;

public class Principal {
    public static void main(String[] args){
        // UPCASTING : COnvertir de SubClases en SuperClases
        // DOWNCASTING : Ir a la jerarquia de clases hacia abajo
        Vehiculo vehiculo = new VehiculoDeportivo("GT23", "ksjd", "skjd", 500);
        VehiculoDeportivo nuevoVehiculo = (VehiculoDeportivo) vehiculo;

        


        Vehiculo misVehiculos[] = new Vehiculo[4]; // Reservar memoria para 4 vehiculos


        misVehiculos[0] = new Vehiculo("ZN5510", "Ferrari", "A89");

        // Polimorfismo
        // Objeto de la clase padre guarda un objeto de la clase Hija.
        misVehiculos[1] = new VehiculoTurismo("flxy81", "Audi", "P14", 4);
        misVehiculos[2] = new VehiculoDeportivo("ZZN20", "TOYOTA", "KJ8", 500);
        misVehiculos[3] = new VehiculoFurgoneta("FLXK51", "TOYOTA","JJ18", 2000);

        for(Vehiculo vehiculos : misVehiculos){
            System.out.println(vehiculos.mostrarDatos());
            System.out.println("");
        }
    }
}
