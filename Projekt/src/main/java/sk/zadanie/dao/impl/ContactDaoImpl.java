package sk.zadanie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dao.UserDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;

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
