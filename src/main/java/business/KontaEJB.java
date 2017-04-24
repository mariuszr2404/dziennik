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
import model.Konta;

/**
 *
 * @author mariu
 */
@Stateless
public class KontaEJB {

    @PersistenceContext(unitName = "com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU")
    
    
    public List<Konta> findAllUsers()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Konta> query = em.createNamedQuery("Konta.findAll", Konta.class);
        List<Konta> lista = query.getResultList();
        return lista;
    }
    
    public Konta findKonta(String username,String password)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Konta> q = em.createQuery("Select k from Konta k where k.username = :username and k.password = :password",Konta.class);
        q.setParameter("username",username);
        q.setParameter("password",password);
        
        return q.getSingleResult();
    }
    
    public void addKonto(Konta k)
    {   
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(k);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
