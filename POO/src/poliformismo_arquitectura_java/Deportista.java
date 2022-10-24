
package poliformismo_arquitectura_java;

public class Deportista extends Persona{
    public Deportista(String nombre){
        super(nombre);
    }    

    @Override
    public int correr() {
        return 7;
    };
    
}
