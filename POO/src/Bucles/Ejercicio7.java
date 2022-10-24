package Bucles;

import javax.swing.JOptionPane;

public class Ejercicio7 {
    public static void main(String[] args){
        int suma=0;
        int contador=0;
        int numero ;
        
        do{
            numero = Integer.parseInt(JOptionPane.showInputDialog("Digite numero "));
            if(numero >= 0){
            contador++;
            suma+=numero;
                
            }
                       
        }while(numero >=0);
        
        System.out.println("La media es : "+ suma/contador);
    }
}
