
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.PersonaDAO;
import vista.VistaPersona;


public class PersonaControlador implements ActionListener {

    private VistaPersona vista;
    private Persona persona;
    private PersonaDAO personaDAO;

    public PersonaControlador(VistaPersona vista, Persona persona, PersonaDAO personaDAO) {
        this.vista = vista;
        this.persona = persona;
        this.personaDAO = personaDAO;
        // de donde vamos a utilizar el ActionListener
        vista.btnInsertar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnUpdate.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("CRUD MVC");
        vista.setLocationRelativeTo(null);
        vista.txtId.setVisible(false);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnInsertar){
           persona.setNombre(vista.txtNombre.getText());
           persona.setDomicilio(vista.txtDomicilio.getText());
           persona.setCelular(vista.txtCelular.getText());
           persona.setCorreo(vista.txtCorreo.getText());
           persona.setFecha(Date.valueOf(vista.txtFecha.getText()));
           persona.setGenero(vista.cbGeneros.getSelectedItem().toString());
           persona.setClave(vista.txtClave.getText());
           
           if(personaDAO.insertar(persona)){
               JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
               limpiar();
           }else{
               JOptionPane.showMessageDialog(null, "Error al insertar registro");
               limpiar();
           }   
        }
        
        if(e.getSource() == vista.btnBuscar){
            persona.setClave(vista.txtBuscar.getText());
           if(personaDAO.obtenerPersona(persona)){
               vista.txtId.setText(String.valueOf(persona.getIdPersona()));
               vista.txtClave.setText(persona.getClave());
               vista.txtNombre.setText(persona.getNombre());
               vista.txtCelular.setText(persona.getCelular());
               vista.txtCorreo.setText(persona.getCorreo());
               vista.txtDomicilio.setText(persona.getDomicilio());
               vista.txtFecha.setText(String.valueOf(persona.getFecha()));
               vista.cbGeneros.setSelectedItem(persona.getGenero());
                
               
           }else{
               JOptionPane.showMessageDialog(null, "No se han encontrado datos");
               limpiar();
           }
        }
        
        if(e.getSource() == vista.btnUpdate){
            persona.setIdPersona(Integer.parseInt(vista.txtId.getText()));
            persona.setNombre(vista.txtNombre.getText());
            persona.setDomicilio(vista.txtDomicilio.getText());
            persona.setCelular(vista.txtCelular.getText());
            persona.setCorreo(vista.txtCorreo.getText());
            persona.setFecha(Date.valueOf(vista.txtFecha.getText()));
            persona.setGenero(vista.cbGeneros.getSelectedItem().toString());
            persona.setClave(vista.txtClave.getText());
            
            if(personaDAO.modificar(persona)){
                JOptionPane.showMessageDialog(null, "Modificado correctamente");
                 limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "no se ha podido modificar correctamente");
                 limpiar();
            }
        }
        
        if(e.getSource() == vista.btnEliminar){
            persona.setIdPersona(Integer.parseInt(vista.txtId.getText()));
            if(personaDAO.eliminar(persona)){
                JOptionPane.showMessageDialog(null, "Eliminado correctamente");
                 limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "no se ha podido Eliimnar correctamente");
                 limpiar();
            }
        }
        
        if(e.getSource() == vista.btnLimpiar){
            limpiar();
        }
    }
    
    public void limpiar(){
        vista.txtId.setText(null);
        vista.txtBuscar.setText(null);
        vista.txtClave.setText(null);
        vista.txtNombre.setText(null);
        vista.txtDomicilio.setText(null);
        vista.txtCelular.setText(null);
        vista.txtCorreo.setText(null);
        vista.txtFecha.setText(null);
        vista.cbGeneros.setSelectedIndex(0);
        
    };
    
}
