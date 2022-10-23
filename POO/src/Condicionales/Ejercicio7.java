
package Condicionales;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numero1, numero2, numero3;
        System.out.print("ingresar primer numero  : ");
        numero1 = s.nextInt();
        System.out.print("Ingresar segundo numero : ");
        numero2 = s.nextInt();
        System.out.print("Ingresar tercer numero : ");
        numero3 = s.nextInt();
        
        if(numero1 > numero2 && numero2 > numero3){
            System.out.println(numero1 + " - " + numero2 + " - " + numero3);
        }else if(numero1 > numero3 && numero3 > numero2){
            System.out.println(numero1 + " - " + numero2 + " - " + numero3);

        }else if(numero2 > numero3 && numero3 > numero1){
            System.out.println(numero1 + " - " + numero2 + " - " + numero3);

        }else if(numero3>numero1 && numero1 > numero2){
            System.out.println(numero1 + " - " + numero2 + " - " + numero3);

        }
    }
}
