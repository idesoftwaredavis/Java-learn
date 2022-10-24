/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bucles;

import javax.swing.JOptionPane;

/**
 *
 * @author sentrauser3268
 */
public class Ejercicio8 {
    public static void main(String[] args){
        int numero, contador = 0;
        
        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
        
        while(numero >= 0){
            contador++;
            numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero : "));
        }
        
        System.out.println("Numeros : " + contador);
    }   
}
