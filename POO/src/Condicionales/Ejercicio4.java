package Condicionales;

import javax.swing.*;

/*
*   En MegaPlaza se hace un 20% de descuento a los clientes
*   cuya compra supere los $300.
*
*   ¿Cual será la cantidad que pagará una persona por su compra?
*
* */
public class Ejercicio4 {
    public static void main(String[] args){
        double compraCliente = Double.parseDouble(JOptionPane.showInputDialog("Total Compra del cliente : "));
        double descuento;
        double totalCliente;
        if(compraCliente > 300){
            // precioCompra -= descuento;
            descuento = (compraCliente * 20 ) / 100;
            totalCliente = compraCliente-descuento;
            JOptionPane.showMessageDialog(null,"Tiene descuento de 20% y es : " + compraCliente);
            JOptionPane.showMessageDialog(null,"El cliente debe pagar : "+ totalCliente);
        }else{
            JOptionPane.showMessageDialog(null,"No posee descuento en su compra");
        }
    }
}
