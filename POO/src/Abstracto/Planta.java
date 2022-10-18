package Abstracto;

public class Planta extends SerVivo{

    // Sobre escribiendo el metodo abstracto de la clase Padre.
    @Override
    public void alimentarse(){
        System.out.println("La planta se alimenta a traves de la fotosintesis");
    }
}
