
package control;

import datos.FuncionariosDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionarios;


public class FuncionarosControl {
    public List<Funcionarios> listar(){
        return new FuncionariosDAO().listar();
    }
    
    public void insertar(Funcionarios f ){
        new FuncionariosDAO().insertar(f); 
    }
    
    public Funcionarios buscar ( Funcionarios f) {
        return new FuncionariosDAO().buscar(f);
    }
    
    public void modificar(Funcionarios f){
        new FuncionariosDAO().modificar(f);
    }
    
    public void eliminar ( Funcionarios f){
         new FuncionariosDAO().eliminar(f);
    }
}
