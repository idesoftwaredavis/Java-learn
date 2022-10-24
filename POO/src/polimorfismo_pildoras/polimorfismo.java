package polimorfismo_pildoras;

public class polimorfismo {
    public static void main(String[] args){
        // Un objeto cambia de forma segun el contexto.
        // Aca cambio la forma cuando le decimos que un empleado ahora sera un objeto de tipo director
        Empleado emp1 = new Director();
        Director dir1 = new Director();
        emp1.trabaja();
        Empleado emp = new Empleado();
        System.out.println(emp1.getClass().getSimpleName());
        System.out.println(emp.getClass().getSimpleName());
        
  
    }
};

