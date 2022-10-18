package Condicionales;

import javax.swing.*;

public class Ejercicio3_LetraMayuscula {
    public static void main(String[] args){
        char letra;
        letra = JOptionPane.showInputDialog("Digite una letra ").charAt(0);

        if(Character.isUpperCase(letra)){
            JOptionPane.showMessageDialog(null,"Es una letra Mayuscula");
        }else{
            JOptionPane.showMessageDialog(null,"Es una letra minuscula");
        }
    }
}
