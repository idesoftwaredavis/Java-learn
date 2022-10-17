/*
    Una empresa de envio de paquetes tiene varias sucursales en todo el pais.
    Cada sucursal esta definida por :
            * Numero de sucursal
            * Direccion
            * Ciudad

    Para calcular el precio que cuesta enviar cada paquete, las sucursales
    tienen en cuenta el peso del paquete y la prioridad, sabiendo que se cobra
    un dolar por kilo. 
            
            10 dolares si la prioridad es alta
            20 si es express.

    Cada paquete enviado tendrá un numero de referencia y el DNI de la persona 
    que lo envia.


*/
package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {
    // Buscar sucursal
    public static int buscarSucursal(Sucursal[] sucursales, int numeroSucursal, int cantidadSucursal){
        int encontrado = 0;
        int indice= 0;
        for(int i=0; i< cantidadSucursal; i++){
            if(sucursales[i].getNumeroSucursal() == numeroSucursal){
                encontrado = 1;
                indice= i;
            }
        }

        if(encontrado == 0){
            indice=-1;
        }
        return indice;
    }

    // Buscar paquete
    public static int buscarPaquete(Paquete[] paquetes, int numeroPaquete, int cantidadPaquete){
        int encontrado = 0;
        int indice= 0;
        for(int i=0; i< cantidadPaquete; i++){
            if(paquetes[i].getNumeroPaquete() == numeroPaquete){
                encontrado = 1;
                indice= i;
            }
        }

        if(encontrado == 0){
            indice=-1;
        }
        return indice;
    }


    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        // sucursal
        int cantidadSucursal = 0;
        int cantidadPaquete = 0;
        int estaSucursal;
        int estaPaquete;
        int numeroSucursal, numeroPaquete, prioridad, opcion;
        String direccion, ciudad, dni;
        double peso;

        Sucursal sucursal[] = new Sucursal[50]; // Array de objetos
        Paquete paquete[] = new Paquete[100]; // Array de objetos

        do{
            System.out.println("\t : MENU");
            System.out.println("\t 1. Crear una nueva sucursal");
            System.out.println("\t 2. Enviar paquete");
            System.out.println("\t 3. Consultar Sucursal");
            System.out.println("\t 4. Consultar paquete");
            System.out.println("\t 5. Mostrar todas las sucursales");
            System.out.println("\t 6  Mostrar todos los paquetes");
            System.out.println("\t 7. Salir");
            System.out.println("Digite la opcion de menu");
            opcion = entrada.nextInt();

            switch(opcion){
                case 1:

                    System.out.print("\nNumero de sucursal : ");
                    numeroSucursal = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Direccion : ");
                    direccion = entrada.nextLine();
                    entrada.nextLine();
                    System.out.print("Ciudad : ");
                    ciudad = entrada.nextLine();

                    sucursal[cantidadSucursal] = new Sucursal(numeroSucursal,direccion,ciudad);
                    cantidadSucursal++;
                    System.out.println("SUCURSAL CREADA EXITOSAMENTE");
                    break;
                case 2:
                    System.out.println("¿ A que sucursal deseas enviar el paquete ?");
                    System.out.print("Ingresar numero de sucursal : ");
                    numeroSucursal = entrada.nextInt();
                     estaSucursal = Ejercicio8.buscarSucursal(sucursal, numeroSucursal, cantidadSucursal);
                    if(estaSucursal == -1 ){
                        System.out.println("Sucursal no existe ");
                    }else{
                        System.out.print("Numero de Paquete : ");
                        numeroPaquete = entrada.nextInt();
                        entrada.nextLine();
                        System.out.print("DNI : ");
                        dni = entrada.nextLine();
                        entrada.nextLine();
                        System.out.print("PESO :");
                        peso = entrada.nextInt();
                        System.out.print("PRIORIDAD ( 0 = NORMAL, 1= ALTA , 2 = EXPRESS");
                        prioridad = entrada.nextInt();

                        paquete[cantidadPaquete] = new Paquete(numeroPaquete,dni,peso,prioridad);
                        cantidadPaquete ++;

                        // calcular precio
                        double precioPaquete = sucursal[estaSucursal].calcular_precio(paquete[cantidadPaquete]);
                        System.out.println("El precio del paquete es : " + precioPaquete);
                        cantidadPaquete++;

                    }
                    break;

                case 3:
                    System.out.print("\nNumero de sucursal : ");
                    numeroSucursal = entrada.nextInt();

                    estaSucursal = buscarSucursal(sucursal,numeroSucursal,cantidadSucursal);

                    if(estaSucursal == -1 ){
                        System.out.println("La sucursal no existe");
                    }else{
                        System.out.println("\n los datos de la sucursal son : ");
                        System.out.println(sucursal[estaSucursal].mostrarDatosSucursal());
                    }
                    break;
                case 4:
                    System.out.print("\nIngresar el numero de paquete ");
                    numeroPaquete = entrada.nextInt();
                    estaPaquete = Ejercicio8.buscarPaquete(paquete, numeroPaquete, cantidadPaquete);

                    if(estaPaquete == -1 ){
                        System.out.println("paquete no existe ");
                    }else{
                        System.out.println("\n los datos del paquete son : ");
                        System.out.println(paquete[estaPaquete].mostrarDatosPaquete());
                    }
                case 5:
                    System.out.println("\n SUCURSALES : ");

                    for(int i=0; i<sucursal.length; i++){
                        System.out.println(sucursal[cantidadSucursal].mostrarDatosSucursal());
                    }
                    break;
                case 6:
                    System.out.println("\n PAQUETES : ");

                    for(int i=0; i<cantidadPaquete; i++){
                        System.out.println(paquete[cantidadPaquete].mostrarDatosPaquete());
                    }
                    break;
                case 7: break;

                default:
                    System.out.println("Opcion de menu incorrecta"); break;

            }
            System.out.println("");
        }while(opcion != 7);

    }




}
