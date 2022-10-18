package Operadores;
/*
*   La calificacion final de un estudiante de informatica
*   se calcula con base a las calificaciones de cuatro aspectos
*   de su rendimiento academico:
*
*   1. Participacion
*   2. Primer examen parcial
*   3. Segun examen parcial
*   4. Examen final.
*
*   Sabiendo que las calificaciones anteriores entran a la
*   calificacion final con ponderaciones del 10%, 25%,25%, 40%.
*
*   Hacer un programa que calcule e imprima la calificacion
*   final obtenida por un estudiante.
*
* */

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float participacion, primerExamen, segundoExamen, examenFinal,
                notaFinal;

        // Pedir datos necesarios
        System.out.print("Digitar la nota de participacion : ");
        participacion = entrada.nextFloat();

        System.out.print("Digitar la primera nota parcial : ");
        primerExamen = entrada.nextFloat();

        System.out.print("Digitar la segunda nota parcial : ");
        segundoExamen = entrada.nextFloat();

        System.out.println("Digitar el examen final : ");
        examenFinal = entrada.nextFloat();

        // Lo incremento en un 10%;
        participacion *=  0.10f;
        primerExamen *= 0.25f;
        segundoExamen *= 0.25f;
        examenFinal *= 0.40f;

        notaFinal = participacion + primerExamen + segundoExamen + examenFinal;

        System.out.println("Nota final del estudiante : "+ notaFinal);
    }
}
