package Condicionales;

import java.util.Scanner;

public class Ejercicio12 {
    
    public static String estadoNota(int nota){
        String estadoNota = "";
        if((nota>=1)&& (nota <=3)){
            estadoNota = "Insuficiente";
        }else if((nota >= 4) && (nota <= 5)){
            estadoNota = "Suficiente";
        }else if((nota>=6) && (nota<= 7)){
            estadoNota = "Sobresaliente";
        }
        return estadoNota;
    };
    
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int nota;
        System.out.println("Ingrese nota ");
        nota = s.nextInt();
        
        if((nota >= 1) && (nota<= 10)){
            System.out.println(estadoNota(nota));    
        }else{
            System.out.println("Fuera de rango");
        }
        
    }
}
