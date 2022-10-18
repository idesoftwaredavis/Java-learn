package Operadores;

import java.util.Scanner;

/*
    Binomio cuadrado de newton

* Cuadrado de una suma : (a+b)2 = a2 + b2 + 2ab
* */
public class Ejercicio6 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        double a, b, resultado;

        System.out.print("Digite el valor de A : ");
        a = entrada.nextDouble();

        System.out.println("Digite el valor de B : ");
        b = entrada.nextDouble();

        resultado = Math.pow(a, 2) + Math.pow(b, 2) + (2*a*b);
        System.out.println("El resultado es : "+ resultado);
    }
}
