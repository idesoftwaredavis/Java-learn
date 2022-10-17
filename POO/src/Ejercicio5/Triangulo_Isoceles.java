package Ejercicio5;

// Perimetro : Suma de todo el contorno de la figura
// Triangulo isoceles: Dos lados iguales y una base : P = 2 x 1 + b 

// A partir de un arreglo de triangulos, devuelva el area del triangulo de mayor superficie
public class Triangulo_Isoceles {
    private double base;
    private double lado; // isolceles tiene dos lados iguales

    public Triangulo_Isoceles(double base, double lado) {
        this.base = base;
        this.lado = lado;
    }
    
    public double obtenerPerimetro(){
        double perimetro = 2 * lado + base;
        return perimetro;
    }
    
    public double obtenerArea(){
        double area = (base*Math.sqrt((lado*lado) - ((base*base) /4))) / 2;
        return area;
    }
    
}
