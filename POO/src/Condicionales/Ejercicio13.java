package Condicionales;

import java.util.Scanner;

public class Ejercicio13 {
   public static void main(String[] args){
       Scanner entrada = new Scanner(System.in);
       
       int saldoInicial = 1000;
       int dinero;
       int opcion=0;
       
       do{
           System.out.println("Bank Account");
           System.out.println("1. Ingresar dinero");
           System.out.println("2. Retirar dinero de la cuenta");
           System.out.println("3. salir");
           opcion = entrada.nextInt();
           
           switch(opcion){
               case 1:
                   System.out.print("Ingrese la cantidad de dinero que desea ingresar : ");
                   saldoInicial += entrada.nextInt();
                   break;
               case 2:
                   System.out.println("Ingrese la cantidad de dinero que desea retirar :");
                   dinero = entrada.nextInt();
                   if(saldoInicial < dinero){
                       System.out.println("Saldo insuficiente para retirar");
                   }else{
                        saldoInicial -= entrada.nextInt();    
                   }    
                   
                   break;
               case 3:break;
               
           }
       }while(opcion != 3);
       
       System.out.println("Saldo Final : "+ saldoInicial);
   } 
}
