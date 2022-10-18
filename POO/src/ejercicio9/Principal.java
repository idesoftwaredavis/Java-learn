package ejercicio9;


import java.util.ArrayList;
import java.util.Scanner;

/*
*   Se crean variables Static para ser ocupadas durante toda la clase
*   Se crean metodos estaticos para llenar datos y guardarlos en el ArrayList
*   Al guardar los objetos de tipo Triangulo y Rectangulos en el ArrayList de tipo Poligono
*   Se esta cumpliendo el Polimorfismo. En donde el metodo que utilizará, se comportara
*   de forma distinta en ambos casos.
* */
public class Principal {

    static ArrayList<Poligono> poligono = new ArrayList<Poligono>();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args){
        // Llenar un poligono
        llenarPoligono();

        mostrarResultados();
    }

    public static void llenarPoligono(){
        int opcion;
        char respuesta;
        do{
            do{
                System.out.println("Digite que poligono desea");
                System.out.println("1. Triangulo");
                System.out.println("2. Reactangulo");
                System.out.println("Opcion : ");
                opcion = entrada.nextInt();

                switch(opcion){
                    case 1: llenarTriangulo();
                        break;
                    case 2: llenarRectangulo();
                        break;
                }
            }while(opcion<1 || opcion>2);
            System.out.println("Dese introducir otro poligono (S/N)");
             respuesta = entrada.next().charAt(0);
        }while(respuesta== 's' || respuesta=='S');
    }

    public static void llenarTriangulo(){
        double lado1,lado2,lado3;
        System.out.println("Digite el lado 1 del triangulo");
        lado1 = entrada.nextDouble();
        System.out.println("Digite el lado 2 del triangulo");
        lado2 = entrada.nextDouble();
        System.out.println("Digite el lado 3 del triangulo");
        lado3 = entrada.nextDouble();

        Triangulo triangulo = new Triangulo(lado1,lado2,lado3);

        // guardamos un triangulo dentro de nuestro arreglo de poligonos
        poligono.add(triangulo);
    }

    public static void llenarRectangulo(){
        double lado1,lado2;
        System.out.println("Digite el lado 1 del rectangulo");
        lado1 = entrada.nextDouble();
        System.out.println("Digite el lado 2 del rectangulo");
        lado2 = entrada.nextDouble();

        Rectangulo rectangulo = new Rectangulo(lado1,lado2);
        poligono.add(rectangulo);
    }

    public static void mostrarResultados(){
        for(Poligono p : poligono){
            System.out.println(p.toString());
            System.out.println(p.area());
        }
    }

}
