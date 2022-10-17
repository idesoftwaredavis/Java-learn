package Operadores;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
        float nota1 = 0,nota2 = 0,nota3 = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresar numeros ");
        nota1 = entrada.nextFloat();
        nota2 = entrada.nextFloat();
        nota3 = entrada.nextFloat();

        float suma = nota1 + nota2 + nota3;

        System.out.println("\n La suma es : " + suma);
    }
}
