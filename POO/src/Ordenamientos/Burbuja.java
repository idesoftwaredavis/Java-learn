package Ordenamientos;

import javax.swing.*;
import java.util.Scanner;

public class Burbuja {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int arreglo[];
        int nElementos;
        int aux;

        nElementos = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad del arreglo : "));

        arreglo = new int[nElementos];

        // Digitamos los numeros dentro del arreglo
        for(int i=0; i<nElementos; i++){
            System.out.println((i+1) + " . Digite un numero : " );
            arreglo[i] = entrada.nextInt();
        }

        // metodo burbuja
        for(int i=0;i<(nElementos-1); i++){
            for(int j=0; j< (nElementos-1) ; j++){
                if(arreglo[j] > arreglo[j+1]){ // Si el numero es mayor al siguiente que le sigue
                    // Se cambia posicion
                    aux = arreglo[j]; // posicion actual
                    arreglo[j] = arreglo[j+1] ;// ahora la posiciona actual vale lo que vale el siguiente elemento
                    arreglo[j+1] = aux;
                }
            }
        }

        // Mostrando data
        for( int i = 0; i <nElementos  ;i++){
            System.out.println(arreglo[i] + " -  ");
        }

        // Al reves
        // variable i vale el total de elementos - 1 ( por que el arreglo comienza de 0 )
        // recorra el arreglo  mientras que i sea mayor o igual a 0
        // se recorrera desde la ultima posicion ( i-- )
        for(int i= (nElementos-1); i>= 0 ; i--){
            System.out.println((i+1) + " --- ");
        }
    }
}
