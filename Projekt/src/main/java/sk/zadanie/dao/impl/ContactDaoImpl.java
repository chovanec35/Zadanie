package sk.zadanie.dao.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Category;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.impl.UtilService;

@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    UtilService utilService;

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

    public ContactDto setParamertersNull(ContactDto contactDto) {
        if (contactDto.getFirstName() == null) {
            contactDto.setFirstName("");
        }
        if (contactDto.getLastName()== null) {
            contactDto.setLastName("");
        }
        if (contactDto.getBirthdate()== null) {
            contactDto.setBirthdate("");
        }
        if (contactDto.getCategory()== null) {
            contactDto.setCategory("");
        }
        return contactDto;
    }

    public void addNewContact(ContactDto contactDto, User user, Date date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Category category = new Category();
        category.setCategoryId(Integer.parseInt(contactDto.getCategory()));
        Date dateTs = new Date();
        Contact contact = new Contact(contactDto.getFirstName(), contactDto.getLastName(), contactDto.getDescription(), date, dateTs, category, user, false);

        em.getTransaction().begin();
        em.persist(contact);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public List<Contact> getAllContacts(User user, ContactDto contactDto, int page) throws ParseException {
        String hql = "SELECT c FROM Contact c "
                + "WHERE c.userId.userId = :userId AND c.flagDel = false";
        Query query = utilService.createQuery(user, contactDto, hql);

        query.setFirstResult((page - 1) * 5);
        query.setMaxResults(5);
        return query.getResultList();
    }

}
