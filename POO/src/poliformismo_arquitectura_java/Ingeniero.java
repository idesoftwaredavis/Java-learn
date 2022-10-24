
package poliformismo_arquitectura_java;

public class Ingeniero extends Persona {
    public Ingeniero(String nombre){
        super(nombre);
    }

    @Override
    public int correr() {
        return 3;
    }
    
}
