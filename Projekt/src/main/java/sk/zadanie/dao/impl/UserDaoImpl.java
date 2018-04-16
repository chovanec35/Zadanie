package sk.zadanie.dao.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;
import sk.zadanie.dao.UserDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.Category;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.impl.UtilService;
import sk.zadanie.validator.UserValidator;

@Repository
@SessionAttributes("loggedUser")
public class UserDaoImpl implements UserDao {

    @Autowired
    DataSource datasource;

    @Autowired
    UserValidator userValidator;
    
    @Autowired
    UtilService utilService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> getAllContacts(User user, ContactDto contactDto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Contact.findByUserId");

        if (contactDto.getCategory() != "" && contactDto.getCategory() != null) {
            Category category = new Category();
            category.setCategoryId(Integer.parseInt(contactDto.getCategory()));
            query.setParameter("categoryId", category);
        } else {
            query = em.createNamedQuery("Contact.findByUserIdWithoutCategory");
        }

        query.setParameter("userId", user);
        query.setParameter("firstName", contactDto.getFirstName() + '%');
        query.setParameter("lastName", contactDto.getLastName() + '%');

        List<Contact> contacts = (List<Contact>) query.getResultList();

        em.close();
        emf.close();

        return contacts;
    }

    @Override
    public User loginUser(LoginDto login) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("User.findByEmailPassword");

        query.setParameter("email", login.getEmail());
        query.setParameter("password", login.getPassword());

        List<User> logins = (List<User>) query.getResultList();

        em.close();
        emf.close();
        
        System.out.println("loginUser()" + logins);
        if (logins.size() == 0){
            User user = null;
            return user;
        }
        
        return logins.get(0);
    }

    @Override
    public void registration(UserDto user, Date date) {
        
        String sql = "insert into users (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, BIRTHDATE) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getFirstName(), user.getLastName(),
            user.getPassword(), user.getEmail(), date});
    }

    @Override
    public void addNewContact(ContactDto contactDto, int userId) {
        String sql = "insert into contacts (FIRST_NAME, LAST_NAME, DESCRIPTION, CATEGORY_ID, USER_ID, BIRTHDATE, CREATION_TS) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{contactDto.getFirstName(),
            contactDto.getLastName(), contactDto.getDescription(), contactDto.getCategory(), userId, contactDto.getBirthdate(), contactDto.getCreationTs()});
    }
}
