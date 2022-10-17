package Operadores;

import java.util.Scanner;

/*
    Guillermo tiene N dolares.
    Luis tiene la mitad de lo que posee Guillermo.
    Juan tiene la mitad de lo que poseen Luis y Guillermo Juntos.
    Hacer un programa que calcule e imprima la cantidad de dinero
    que tienen entre los tres.
 */
public class Ejercicio3 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        int Guillermo;
        System.out.print("Cuantos dolares tiene Guillermo :");
        Guillermo = entrada.nextInt();

        int Luis = Guillermo/ 2;

        int Juan = (Guillermo + Luis) / 2;

        int total = Guillermo + Luis + Juan;

        System.out.println("Guillermo tiene en dolares : " + Guillermo);
        System.out.println("Luis tiene en dolares : " + Luis);
        System.out.println("Juan tiene en dolares : " + Juan);
        System.out.println("El total entre los tres : " + total);
    }
}
