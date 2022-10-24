package Condicionales;

import javax.swing.JOptionPane;

public class Ejercicio14 {
    public static void main(String[] args){
        float medida;
        
        int opcion ;
        medida = Float.parseFloat(JOptionPane.showInputDialog("Digite la cantidad de kilogramos"));
        
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Menu\n"
                + "1. Hectogramos"
                + "2. Decagramos"
                + "3. Gramo "
                + "4. Decigramos"
                + "5. Centigramos"
                + "5. Miligramos"));
        
        switch(opcion){
            case 1:
                medida *= 10;
                JOptionPane.showMessageDialog(null, "La nueva medida en Hectogramos es : "+ medida);
                break;
            case 2:
                medida *= 100;
                JOptionPane.showMessageDialog(null, "La nueva medida en Decagramo es : "+ medida);
                break;
            case 3:
                medida *= 1000;
                JOptionPane.showMessageDialog(null, "La nueva medida en Gramos es : "+ medida);
                break;
                
            case 4: 
                medida *= 10000;
                JOptionPane.showMessageDialog(null, "La nueva medida en Decigramos es : "+ medida);
                break;
            case 5:
                medida *= 100000;
                JOptionPane.showMessageDialog(null, "La nueva medida en Centigramos es : "+ medida);
                break;
            case 6:
                medida += 1000000;
                JOptionPane.showMessageDialog(null, "La nueva medida en Miligramos es : "+ medida);
                break;
        }
        
    }
}
