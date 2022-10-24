package poliformismo_arquitectura_java;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Programa {

    public static void main(String[] args) {
        // Polimorfismo
        /*
        Ingeniero i = new Ingeniero("Pedro");
        Deportista d = new Deportista("gema");
        
        Persona ingeniero1 = i;
        Persona deportista2 = d;
        
        
        
        System.out.println(ingeniero1.correr());
        System.out.println(deportista2.correr());
         */

        Persona i1 = new Ingeniero("pedro");
        Persona d1 = new Deportista("gema");
        Persona i2 = new Ingeniero("angel");
        Persona i3 = new Ingeniero("antonio");
        Persona i4 = new Ingeniero("maria");
        Persona d5 = new Deportista("david");
        List<Persona> lista = Arrays.asList(i1, d1, i2, i3, i4, i4, d5);
        OptionalDouble resultado = calcularMediaVelocidad(lista);
        if (resultado.isPresent()) {
            System.out.println(resultado.getAsDouble());
        }
    }
    
    public static OptionalDouble calcularMediaVelocidad(List<Persona> lista){
        return lista.stream().mapToDouble(Persona::correr).average();
    }
}
