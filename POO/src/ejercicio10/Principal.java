package ejercicio10;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static ArrayList<Persona> persona = new ArrayList<Persona>();
    // Polimorfismo -- UPCASTING
    static Persona futbolista = new Futbolista("Gonzalo","Higuain",35,9, "Central");
    static Persona futbolista2 = new Futbolista("Futbolista 2 ", "Futbolista2", 20, 10, "Ernesta");
    static Persona entrenador = new Entrenador("Entrenador","Entrenador",10, "estrategi");
    static Persona medico = new Medico("Medico","Medico",50,"Doctorado en ciencas publicas", 10);


    public static void main(String []args){
            // menu
            persona.add(futbolista);
            persona.add(futbolista2);
            persona.add(entrenador);
            persona.add(medico);

            menu();
    }


    public static void menu(){
        Scanner entrada = new Scanner(System.in);
        int opcion ;
        do{
            System.out.println("\t.:Menu:.");
            System.out.println("1. Viaje de equipo");
            System.out.println("2. Entrenamiento");
            System.out.println("3. Partido de Futbol");
            System.out.println("4. Planificar entrenamiento");
            System.out.println("5. Entrevista");
            System.out.println("6. Curar lesion");
            System.out.println("7. Salir");
            System.out.println("Opcion   ");
            opcion = entrada.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("");
                    viajarEquipo();
                    break;
                case 2:
                    System.out.println("");
                    entrenarEquipo();
                    break;
                case 3:
                    partidoFutbol();
                    break;
                case 4:planificarEntrenamiento();
                    break;

                case 5:
                    System.out.println("");
                    DarEntrevista();
                    break;
                case 6:
                    System.out.println("");
                    curarLesion();
                    break;
                case 7:
                    break;
            }
        }while(opcion != 7);
    }

    public static void viajarEquipo(){
        for(Persona equipo : persona){
            System.out.print(equipo.getNombre() + " - " + equipo.getApellidos() + " - " + equipo.getEdad() );
            equipo.viajar();
        }
    }

    public static void entrenarEquipo(){
        for(Persona equipo : persona){
            System.out.print(equipo.getNombre() + " - " + equipo.getApellidos() + " - " + equipo.getEdad() );
            equipo.entrenamiento();
        }
    }

    public static void partidoFutbol(){
        for(Persona equipo : persona){
            System.out.print(equipo.getNombre() + " - " + equipo.getApellidos() + " - " + equipo.getEdad() );
            equipo.partidoFutbol();
        }
    }

    public static void planificarEntrenamiento(){
        System.out.print(entrenador.getNombre() + " - " + entrenador.getApellidos() + " --> " );
        // Para obtener el metodo propiamente tal del entrenador, hay que hacer un downcasting
        // es decir, bajar en la jerarquia de clases.
        ((Entrenador) entrenador).planificarEntrenamiento();
    }

    public static void DarEntrevista(){
        System.out.print(futbolista.getNombre() + " - " + futbolista.getApellidos() );
        ((Futbolista) futbolista).entrevista();
        ((Futbolista) futbolista2).entrevista();
    }

    public static void curarLesion(){
        System.out.print(medico.getNombre() + " - " + medico.getApellidos());
        ((Medico) medico).curarLesion();
    }
}
