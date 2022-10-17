package ejercicio7;

import java.util.Scanner;

public class Principal {
    
    public static int buscarNumeroCuenta(Cuenta cuentas[], int id){
        int i=0;
        int indice=0;
  
        boolean encontrado = false;
        
        // buscqueda secuencial 
        while((i<cuentas.length) && (encontrado==false)){
            if(cuentas[i].getNumeroCuenta() == id ){
                encontrado = true;
                indice=i;
            }
            i++;
        }
        
        // El indice 0 si existe en el arreglo. Entonces se tnedra que 
        // pasar un -1.
        if(encontrado == false){
            indice = -1;
        }
        return indice;
    } 
            
            
    public static void main(String[] args){
        int indiceCuenta;
        double saldo;
        double cantidad;
        // Entrada para obtener datos escritos por teclado
        Scanner entrada = new Scanner(System.in);
        // Declaro variables
        String nombre, apellido, dni;
        // numeroCuenta : El usuario escribe cual es su numero de cuenta
        // nCuentas : Cuanta cuentas posee el usuario
        int numeroCuenta, nCuentas;
        
        
        Cuenta cuentas[];
        Cliente cliente;
        
        // Obtengo datos del Cliente ( NOMBRE - APELLIDO - DNI - Cuentas ) 
        System.out.print("Digite el nombre del cliente : ");
        nombre = entrada.nextLine();
        System.out.println("Digite el apellido del cliente  ");
        apellido = entrada.nextLine();
        System.out.println("Digite el dni del cliente ");
        dni = entrada.nextLine();
        
        System.out.println("Ahora, digite cuentas cuentas tiene : ");
        nCuentas = entrada.nextInt();
        
        // Arreglo de tipo cuenta con el numero de cuentas que el usuario ingreso.
        cuentas = new Cuenta[nCuentas];
        
        // Bucle for que permite digitar los campos de la clase Cuenta segun el arreglo
        for(int i=0; i<cuentas.length;i++){
            System.out.println("\n digite los datos para la cuenta :" + (i+1) + " :");
            System.out.print("Digite el numero de cuenta ");
            numeroCuenta = entrada.nextInt();
            System.out.println("Digite el saldo de la cuenta ");
            saldo = entrada.nextDouble();
            
            // Por cada registro, se crea un nuevo objeto Cuenta dentro del arreglo.
            cuentas[i] = new Cuenta(numeroCuenta, saldo);
        }
        
        // Una vez creada las cuentas que posee el usuario, es posible crear al cliente.
        cliente = new Cliente(nombre, apellido, dni, cuentas);
        
        int opcion ;
        // Menu
        do{
            System.out.println("\t. : Menu");
            System.out.println("1. Ingresar dinero en la cuenta");
            System.out.println("2. Retirar dinero de la cuenta ");
            System.out.println("3. Consultar saldo de la cuenta");
            System.out.println("4. Salir");
            
            System.out.println("Digite opcion");
            opcion=entrada.nextInt();
            
            switch(opcion){
                case 1: 
                    // Pedir que digite el numero de cuenta
                    System.out.println("\n Digite el numero de cuenta");
                    numeroCuenta = entrada.nextInt();
                    // Buscar si ese numero de cuenta existe
                    indiceCuenta = Principal.buscarNumeroCuenta(cuentas, numeroCuenta);
                    
                    // Si no existe, retorna -1 ( NO EXISTE )
                    if(indiceCuenta == -1){ // nunca encontro el numeroCuenta
                        System.out.println("El numero de cuenta ingresado no existe");
                    }else{
                        System.out.print("\n Digite la cantidad de dinero a ingresar");
                        cantidad = entrada.nextDouble();
                        
                        cliente.ingresar_dinero(indiceCuenta, cantidad);
                        System.out.println("Ingreso realizado correctamente");
                        System.out.println("Saldo disponible : " + cliente.consultar_saldo(indiceCuenta));
                    }
                    break;
                case 2:
                    // Pedir que digite el numero de cuenta
                    System.out.println("\n Digite el numero de cuenta");
                    numeroCuenta = entrada.nextInt();
                    // Buscar si ese numero de cuenta existe
                    indiceCuenta = Principal.buscarNumeroCuenta(cuentas, numeroCuenta);
                    
                    // Si no existe, retorna -1 ( NO EXISTE )
                    if(indiceCuenta == -1){ // nunca encontro el numeroCuenta
                        System.out.println("El numero de cuenta ingresado no existe");
                    }else{
                        System.out.print("Digite la cantidad de dinero que desea retirar");
                        cantidad = entrada.nextDouble();
                        
                        // SI la cantidad que el usuario quiere retirar
                        // Es mayor a la cantidad de dinero que tengo en la cuenta
                        if(cantidad>cliente.consultar_saldo(indiceCuenta)){
                            System.out.println("Saldo insuficiente");
                        }else{
                             cliente.retirar_dinero(indiceCuenta, cantidad);
                             System.out.println("Retirado correctamente ");
                             System.out.println("Saldo disponible : "+ cliente.consultar_saldo(indiceCuenta));
                        }
                    }
                    break;
                case 3: 
                    // Pedir que digite el numero de cuenta
                    System.out.println("\n Digite el numero de cuenta");
                    numeroCuenta = entrada.nextInt();
                    // Buscar si ese numero de cuenta existe
                    indiceCuenta = Principal.buscarNumeroCuenta(cuentas, numeroCuenta);
                    
                    // Si no existe, retorna -1 ( NO EXISTE )
                    if(indiceCuenta == -1){ // nunca encontro el numeroCuenta
                        System.out.println("El numero de cuenta ingresado no existe");
                    }else{
                        System.out.println("El saldo de la cuenta es : " + cliente.consultar_saldo(indiceCuenta));
                    }
                    break;
                case 4: break;
                
                default: System.out.println("Error, se confundio opcion de menu");
                    
            }
        }while(opcion != 4);
    }
}
