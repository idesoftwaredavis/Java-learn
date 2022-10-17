// A partir de un arreglo de triangulos, devuelva el area del triangulo de mayor superficie

package Ejercicio5;

import java.util.Scanner;


public class Principal {
    public static double mayorArea(Triangulo_Isoceles triangulos[]){
        double area;
        // Obtengo esta area para evaluar las demas si es mayor a la primera 
        area = triangulos[0].obtenerArea();
        
        // bucle for para evaluarlo
        for(int i=1; i<triangulos.length;i++){
            // Si el triangulo en la posicion actual es mayor al area obtenida ( Posicion 0) 
            if(triangulos[i].obtenerArea()>area){
                // Sera el nuevo valor del area.
                area = triangulos[i].obtenerArea();
            }
        }
        return area;
    }
    
      public static void main(String[] args){
         Scanner entrada = new Scanner(System.in);
         double base, lado;
         int nTriangulos;
         
          System.out.println("Digite el numero de triangulos a ingresar");
          nTriangulos = entrada.nextInt();
          
          Triangulo_Isoceles triangulos[] = new Triangulo_Isoceles[nTriangulos]; // Array de objetos
          
          for(int i=0; i<triangulos.length;i++){
              System.out.println("\n digite los valores para el triangulo : " + (i+1));
              System.out.print("Introduzca la base: ");
              base = entrada.nextDouble();
              System.out.print("Introduzca le lado : ");
              lado = entrada.nextDouble();
              
              triangulos[i] = new Triangulo_Isoceles(base, lado);
              
              System.out.println("\n el perimetro del triangulo es : "+ triangulos[i].obtenerPerimetro());
              System.out.println("\n el area del triangulo es : "+ triangulos[i].obtenerArea());
          }
          System.out.println("\n El area del triangulo con mayor superficie es : " + Principal.mayorArea(triangulos));
      }
}
