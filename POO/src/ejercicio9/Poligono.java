package ejercicio9;

public abstract class Poligono {
    protected int numeroLados;

    public Poligono(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    public int getNumeroLados() {
        return numeroLados;
    }


    @Override
    public String toString() {
        return "Poligono{" +
                "numeroLados=" + numeroLados +
                '}';
    }

    // Declaramos el metodo area como abstracto
    // Como es generico, se pone abstracto.
    // Las clases hijas van a tener que repsonder a ese metodo.
    public abstract double area();
}
