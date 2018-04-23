package sk.zadanie.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;

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

    @Override
    public Contact getContactById(int contactId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Contact.findByContactId");
        query.setParameter("contactId", contactId);

        List<Contact> contacts = (List<Contact>) query.getResultList();

        em.close();
        emf.close();
        return contacts.get(0);
    }

    public ContactDto setParamertersNull() {
        ContactDto contactDto = new ContactDto();
        contactDto.setFirstName("");
        contactDto.setLastName("");
        contactDto.setBirthdate("");
        contactDto.setCategory("");
        return contactDto;
    }

}
