package Condicionales;

import javax.swing.*;
import java.util.Scanner;

/*
*   Un obrero necesita calcular su salario
*   semanal, el cual se obtiene de la siguiente manera:
*
*   Si trabaja 40 horas o menos se le paga $16 por hora
*
*   Si trabaja mas de 40 horas se le paga $16 por cada
*   una de las primeras 40 horas y
*
*   $20 por cada hora extra.
* */
public class Ejercicio5 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int horasTrabajadas;
        int sueldoFinal;
        int pagar = 0;
        System.out.println("Cuantas horas trabajo : ");
        horasTrabajadas = entrada.nextInt();

        if(horasTrabajadas <= 40 ){
            sueldoFinal= horasTrabajadas *  16;
        }else{
            sueldoFinal =40 * 16;
            horasTrabajadas-=40;
            pagar = sueldoFinal + (horasTrabajadas*20);
        }

        JOptionPane.showMessageDialog(null,"Salario Total : " + pagar + " Dolares ");
    }
}
