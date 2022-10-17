package Operadores;

import java.util.Scanner;

/*
       Hacer un programa que calcule e imprima el salario
       semanal de un empleado a partir de sus horas
       semanales trabajadas y de su salario por hora.
*/
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int horasSemanales;
        float salarioHora, salarioTotal;

        System.out.print("Digite las horas semanales trabajadas");
        horasSemanales = entrada.nextInt();

        System.out.print("Salario que gana por hora : ");
        salarioHora = entrada.nextFloat();

        salarioTotal = horasSemanales * salarioHora;

        System.out.println("El salario semanal es : "+ salarioTotal);
    }
}
