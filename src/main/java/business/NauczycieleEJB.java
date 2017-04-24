/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Nauczyciele;

/**
 *
 * @author mariu
 */
@Stateless
public class NauczycieleEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU")
    
    public List<Nauczyciele> findAllNauczyciele()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Nauczyciele> query = em.createNamedQuery("Nauczyciele.findAll",Nauczyciele.class);
        List<Nauczyciele> lista = query.getResultList();
        return lista;
    }
    
    
}
