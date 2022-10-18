package Operadores;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        int horasTotales, semanas, dias, horas;

        System.out.println("Numero de horas : ");
        horasTotales = entrada.nextInt();

        // Cuantas semanas han pasado
        semanas = horasTotales / 168;
        // Cuantos dias han pasado

        dias = horasTotales%168 / 24;

        // Cuantas horas han pasado
        horas = horasTotales%24;
    }
}
