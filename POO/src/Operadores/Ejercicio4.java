package Operadores;

import java.util.Scanner;

/*
*   Una compañia de venta de carros usados, paga a su personal
*   de ventas un salario de $1000 mensuales, mas una comision de
*   $150 por cada carro vendido.
*
*   Mas el 5% del valor de la venta por carro.
*
*   Cada mes el capturista de la empresa ingresa en la compu
*   los datos pertinentes. Hacer un programa que calcule e
*   imprima el salario mensual de un vendedor dado.
*
*
*   ¿Cual es el precio del auto?
*   ¿Cuantos autos ha vendido?
* */
public class Ejercicio4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        float precioAuto;
        int cantidadAutosVendidos;
        float comisionCantidadAutos = 0;
        int comisionVentaAutos=0;
        final float salarioMensual = 1000;
        System.out.print("Cual es el precio del auto : ");
        precioAuto = s.nextFloat();
        System.out.print("Cuantos autos vendio ? : ");
        cantidadAutosVendidos = s.nextInt();

        comisionCantidadAutos = (5 * precioAuto) / 100;
        if(cantidadAutosVendidos != 0){
            comisionCantidadAutos = cantidadAutosVendidos * 150;
        }

        float sueldoMensualFinal = salarioMensual + comisionCantidadAutos + (0.05f*precioAuto*cantidadAutosVendidos);


        System.out.println("Comision por venta de vehiculo : (+5 porciento )"+(0.05f*precioAuto*cantidadAutosVendidos));
        System.out.println("Comision por cantidad de autos vendidos  (+150 dolares): " + comisionCantidadAutos);
        System.out.println("El sueldo final es : " + sueldoMensualFinal);
    }
}
