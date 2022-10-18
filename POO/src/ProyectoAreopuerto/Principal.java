package ProyectoAreopuerto;


import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4; // numero de aeropuertos
    static Areopuerto aeropuerto[] = new Areopuerto[num];

    public static void main(String[] args){
        // Insertar datos del los aeropuerto
    }

    public static void insertarDatosAeropuerto(Areopuerto aero[]){
        aero[0] = new AeropuertoPublico("Jorge Chavez", "Lima", "Peru", 80000000);
        aero[0].insertarCompania(new Compania("AeroPeru"));
        aero[0].insertarCompania(new Compania("LATAM"));

        // Pasajero que esta dentro del vuelo IB20 que sale desde Lima Mexico que pertenece ala compañia AeroPeru que sale desde la compañia Jorge Chavez.
        aero[0].getCompania("AeroPeru").insertarVuelo(new Vuelo("IB20","Lima","Meximo",150.90, 150));
        aero[0].getCompania("AeroPeru").insertarVuelo(new Vuelo("IB21","Lima", "Buenos Aires", 180.99, 120));
        aero[0].getCompania("LATAM").insertarVuelo(new Vuelo("FC12","Ernesto","Pomposo",1000.20,100));

        aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Davis","123456", "Chilena"));
        aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Maria","PJKL20", "MEXICANA"));
        aero[0].getCompania("LATAM").getVuelo(("FC12")).insertarPasajero(new Pasajero("Raul","ASD","Peruana"));
    }

    public static void mostrarDatosAeropuertos(Areopuerto aeropuertos[]){
        for(int i = 0; i<aeropuertos.length; i++){
            if(aeropuertos[i] instanceof AeropuertoPublico ){
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre : " + aeropuertos[i].getNombre());
                System.out.println("Ciudad : " + aeropuertos[i].getCiudad());
                System.out.println("Pais : "+ aeropuertos[i].getPais());
                
            }
        }
    }

}
