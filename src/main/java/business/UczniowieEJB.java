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
import model.Uczniowie;

/**
 *
 * @author mariu
 */
@Stateless
public class UczniowieEJB {

    @PersistenceContext(unitName = "com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU")

    public List<Uczniowie> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Uczniowie> q = em.createNamedQuery("Uczniowie.findAll", Uczniowie.class);
        List<Uczniowie> list = q.getResultList();
        return list;
    }

    public List<Uczniowie> sortListByImie() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select u " + "from Uczniowie u " + "order by u.imie ASC");
        List<Uczniowie> list = q.getResultList();
        return list;
    }

    public List<Uczniowie> sortListByNazwisko() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select u " + "from Uczniowie u " + "order by u.nazwisko ASC");
        List<Uczniowie> list = q.getResultList();
        return list;
    }
    
    public List<Uczniowie> sortListById() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select u " + "from Uczniowie u " + "order by u.idklasy ASC");
        List<Uczniowie> list = q.getResultList();
        return list;
    }
    
    public List<Uczniowie> sortListByDataUrodzenia() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select u " + "from Uczniowie u " + "order by u.dataurodzenia ASC");
        List<Uczniowie> list = q.getResultList();
        return list;
    } 
    
    public void addUczen(Uczniowie u)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DziennikV5_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        emf.close();
    }
}
