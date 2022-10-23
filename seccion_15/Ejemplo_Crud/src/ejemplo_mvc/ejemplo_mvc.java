
package ejemplo_mvc;
import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;


public class ejemplo_mvc {
    public static void main(String[] args){
        Vista vista= new Vista();
        Modelo model = new Modelo();
        Controlador c = new Controlador(vista, model);
        
        c.iniciar();
        vista.setVisible(true);
    }
}
