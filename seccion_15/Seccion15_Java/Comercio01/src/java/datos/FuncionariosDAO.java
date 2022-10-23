
package datos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.Funcionarios;


public class FuncionariosDAO {
    
        // importar mi unidad de persistencia. 
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Comercio01PU");
    EntityManager em = emf.createEntityManager();
    
    // listar funcionarios
    public List<Funcionarios> listar(){
        TypedQuery<Funcionarios> query = em.createNamedQuery("Funcionarios.findAll", Funcionarios.class);
        List<Funcionarios> result = query.getResultList();
        
        return result;
    }
    
    public void insertar( Funcionarios f ) {
        // Iniciar una transaccion
        em.getTransaction().begin();
        // Insertar en BD
        em.persist(f);
        // persistir los datos con commit 
        em.getTransaction().commit();
    }
    
    public Funcionarios buscar(Funcionarios f){
        f = em.find(Funcionarios.class, f.getId());
        return f;
    }
    
    public void modificar(Funcionarios f){
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }
    
    public void eliminar ( Funcionarios f ) {
        em.getTransaction().begin();
        f = em.find(Funcionarios.class, f.getId());
        em.remove(f);
        em.getTransaction().commit();
    }
            
}
