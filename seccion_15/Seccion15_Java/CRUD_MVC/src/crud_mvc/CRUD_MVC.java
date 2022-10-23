
package crud_mvc;

import controlador.PersonaControlador;
import modelo.Persona;
import modelo.PersonaDAO;
import vista.VistaPersona;


public class CRUD_MVC {

  
    public static void main(String[] args) {
       VistaPersona vista = new VistaPersona();
       Persona persona = new Persona();
       PersonaDAO dao = new PersonaDAO();
       
       PersonaControlador controller = new PersonaControlador(vista, persona, dao);
    
       controller.iniciar();
       vista.setVisible(true);
    }
    
}
