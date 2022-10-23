
package Condicionales;

import java.util.Scanner;

public class Ejercicio9 {
    static String messageError = "Fecha ingresada es incorrecta";
    
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        int dia, mes, ano;
        System.out.print("Ingrese dia : ");
        dia = s.nextInt();
        System.out.print("Ingrese mes : ");
        mes = s.nextInt();
        System.out.print("Ingrese anio : ");
        ano = s.nextInt();
        
        if(dia <= 30 && dia != 0 ){
           if(mes <= 12 && mes != 0){
               if(ano < 10000 && ano >= 1900 || ano <= 2022){
                   System.out.println("Fecha ingresada es correcta");
               }else{
                   System.out.println(messageError);
               }
           }else{
               System.out.println(messageError);
           }
        }else{
           System.out.println(messageError);
        }
        
    }
    
}
