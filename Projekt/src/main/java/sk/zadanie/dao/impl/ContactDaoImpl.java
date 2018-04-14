package sk.zadanie.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import sk.zadanie.dao.ContactDao;

@Repository
//@SessionAttributes("loggedUser")
public class ContactDaoImpl implements ContactDao {

    @Override
    public void delContact(int contactId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Contact.deleteByContactId");
        query.setParameter("flagDel", true);
        query.setParameter("contactId", contactId);
        query.executeUpdate();

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
