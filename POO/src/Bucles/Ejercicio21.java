
package Bucles;

import javax.swing.JOptionPane;

public class Ejercicio21 {
    public static void main(String[] args){
        int contador_negativos =0;
        boolean negativoEncontrado = false;
        int numero;
        for(int i=0;i<10;i++){
            numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce Numero : "));
            
            if(numero < 0){
                contador_negativos++;
                negativoEncontrado = true;
            }
        }
        
        if(negativoEncontrado == true){
            System.out.println("Hubieron numeros negativos ");
            System.out.println("Cantidad : " + contador_negativos);
        }else{
            System.out.println("No hubieron numeros negativos");
        }
        
        
    }
}
