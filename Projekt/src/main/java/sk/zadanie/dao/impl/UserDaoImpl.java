package sk.zadanie.dao.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public List<Contact> getAllContacts(User user, ContactDto contactDto) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Map<String, Object> mapObj = new HashMap<String, Object>();
        Map<String, String> mapStr = new HashMap<String, String>();

        String hql = "SELECT c FROM Contact c "
                + "WHERE c.userId.userId = :userId AND c.flagDel = false";
        mapObj.put("userId", user.getUserId());

        if (!contactDto.getFirstName().isEmpty()) {
            hql += " AND c.firstName LIKE :firstName";
            mapStr.put("firstName", "%" + contactDto.getFirstName() + "%");
        }
        if (!contactDto.getLastName().isEmpty()) {
            hql += " AND c.lastName LIKE :lastName";
            mapStr.put("lastName", "%" + contactDto.getLastName() + "%");
        }
        if (!contactDto.getBirthdate().isEmpty()) {
            hql += " AND c.birthdate = :birthdate";
            Date date = utilService.convertStringToDate(contactDto.getBirthdate());
            mapObj.put("birthdate", date);
        }
        if (!contactDto.getCategory().isEmpty()) {
            hql += " AND c.categoryId = :categoryId";
            Category category = new Category();
            category.setCategoryId(Integer.parseInt(contactDto.getCategory()));
            mapObj.put("categoryId", category);
        }

        Query query = em.createQuery(hql);
        
        for (Map.Entry me : mapStr.entrySet()) {
            query.setParameter((String) me.getKey(), me.getValue());
        }
        for (Map.Entry me : mapObj.entrySet()) {
            query.setParameter((String) me.getKey(), me.getValue());
        }
        return query.getResultList();
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

        if (logins.size() == 0) {
            User user = null;
            return user;
        }
        return logins.get(0);
    }

    @Override
    public boolean emailExist(UserDto userDto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createNamedQuery("User.findByEmail");
        query.setParameter("email", userDto.getEmail());
        List<User> email = (List<User>) query.getResultList();

        em.close();
        emf.close();
        if (email.size() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void registration(UserDto userDto, Date date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getPassword(), userDto.getEmail(), date);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
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
}
