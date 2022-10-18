package Operadores;

import java.util.Scanner;

/*
* Ecuacion de segundo grado de coeficientes reales.
* */
public class Ejercicio8 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        double a, b, c, resultado1, resultado2;

        System.out.println("Digite el valor de a");
        a= entrada.nextDouble();

        System.out.println("Digite el valor de b ");
        b = entrada.nextDouble();

        System.out.println("Digite el valor de c : ");
        c = entrada.nextDouble();

        resultado1 = (-b+Math.sqrt(Math.pow(b,2) - (4 * a * c))) / ( 2 * a );
        resultado2 = (-b-Math.sqrt(Math.pow(b,2) - (4 * a * c))) / (2 * a);

        System.out.println("La raiz es : " + resultado1);
        System.out.println("LA raiz 2 es : " + resultado2);
    }
}
