package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener{
    // Llamo a la vista para poder trabajarla desde el controlador.
    private Vista vista;
    // Llamo al modelo para llamar a las operaciones
    private Modelo modelo;

    // Implemento la interfaz ActionListener para manejar los atributos que estan en la vista.
    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.btnSumar.addActionListener(this);
    }

    
    public void iniciar(){
        vista.setTitle("MVC sumar ");
        vista.setLocationRelativeTo(null);
    }
    
    
    // Cuando el usuario apriete el boton Sumar, Se ira directo para aca
    @Override
    public void actionPerformed(ActionEvent e) {
        // obtengo valores
        modelo.setNumero1(Integer.parseInt(vista.txtNumero1.getText()));
        modelo.setNumero2(Integer.parseInt(vista.txtNumero2.getText()));
        modelo.sumar();
        vista.txtResultado.setText(String.valueOf(modelo.getResultado()));
    }
    
    
    
    
}
