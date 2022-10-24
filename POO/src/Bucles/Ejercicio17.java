
package Bucles;

import javax.swing.JOptionPane;

public class Ejercicio17 {
    public static void main(String[] args){
        int codigo;
        int cant_vendida;
        int cant_mayor600=0;
        
        float precio;
        float facturacionTotal=0;
       
        
        for(int i=0; i<5;i++){
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo "));
            cant_vendida = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad vendida en litros de desinfectantes "));
            precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese precio por litro de desinfectante"));
            
            if(i==0){
                System.out.println("Cantidad litros vendidos articulo 1 : "+ cant_vendida);
            }
            
            facturacionTotal =+ (precio*cant_vendida);
            if(precio*cant_vendida > 600){
                cant_mayor600++;
            }
        }
        
        System.out.println("Facturacion total : " + facturacionTotal);
        System.out.println("Cantidad de facturas emitidas mayor a 600 : " + cant_mayor600);
    }
}
