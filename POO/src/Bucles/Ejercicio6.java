package Bucles;

import javax.swing.JOptionPane;


public class Ejercicio6 {
    public static void main(String[] args){
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero : "));
        int suma =0;
        while(numero != 0){
           suma+= numero;
           numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero : "));
        }
        
        System.out.println("La suma de los numeros introducidos es : "+ suma);
    }
}
