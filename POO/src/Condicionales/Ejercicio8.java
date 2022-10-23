
package Condicionales;

import java.util.Scanner;


public class Ejercicio8 {
    public static void main(String[] args){
        
        Scanner entrada = new Scanner(System.in);
        
        Integer numero=0;
        
        do{
            System.out.println("Escriba un numero del 1 al 99 999");
      
            numero = entrada.nextInt();
        
        } while(numero <1 || numero>99999);
        
        if(numero < 10){
            System.out.println("numero tiene 1 cifra");
        }else if(numero < 100){
            System.out.println("Numero tiene 2 cifras");
        }else if(numero < 1000){
            System.out.println("Numero tiene 3 cifras");
        }else if(numero < 10000){
            System.out.println("Numero tiene 4 cifras");
        }
    }
}
