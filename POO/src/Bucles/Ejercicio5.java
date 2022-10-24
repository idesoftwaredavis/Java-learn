
package Bucles;

import javax.swing.JOptionPane;

public class Ejercicio5 {
    public static void main(String[] args){
        int numero, contador = 0;
        int aleatorio=0;
        aleatorio = (int) (Math.random()*100);
        System.out.println(aleatorio);
        
        do{
          numero = Integer.parseInt(JOptionPane.showInputDialog("Digite numero "));
          
          if(aleatorio > numero ){
              System.out.println("Digite un numero mayor");
          }else{
              System.out.println("Digite un numero menor");
          }
          contador++;
        }while(numero != aleatorio);
        
        System.out.println("Genial, adivinaste el numero aleatorio em " + contador + " intentos ");
    }
}
