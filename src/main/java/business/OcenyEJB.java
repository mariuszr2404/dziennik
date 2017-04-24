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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Oceny;

/**
 *
 * @author mariu
 */
@Stateless
public class OcenyEJB {

    @PersistenceContext(unitName = "com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU")

    public List<Oceny> findOcenaNauczyciel(int idN) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT o FROM Oceny o WHERE o.idnauczyciela = ?1", Oceny.class).setParameter(1, idN);
        return query.getResultList();

    }

    public List<Oceny> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Oceny> q = em.createNamedQuery("Oceny.findAll", Oceny.class);
        List<Oceny> list = q.getResultList();
        return list;
    }

//    public List<Object> findData() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("Select o.idoceny, o.ocena, p.przedmioty from Ocena o, Przemioty p where p.idprzedmiotu = o.idprzedmiotu");
//    }
}
