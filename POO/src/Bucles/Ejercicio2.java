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
public class Ejercicio2 {
    public static void main(String[] args){
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero "));
        
        while(numero != 0){
            if(numero > 0 ){
                System.out.println("El numero : " + numero + " es positivo");
            }else{
                System.out.println("El numero : " + numero + " es negativo ");
            }
            
            numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero "));
        }
    }
}
