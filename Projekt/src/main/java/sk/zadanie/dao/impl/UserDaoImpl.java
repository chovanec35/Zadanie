package sk.zadanie.dao.impl;

import com.sun.jndi.toolkit.ctx.Continuation;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
import sk.zadanie.entity.Contact_;
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
//        em.getTransaction().begin();
        String query = "SELECT c "
                + "FROM Contact c "
                + "WHERE c.userId = :userId";

        if (!contactDto.getFirstName().isEmpty()) {
            query += " AND c.firstName = :firstName";
        }
        if (!contactDto.getLastName().isEmpty()) {
            query += " AND c.lastName LIKE '%" + contactDto.getLastName() + "%'";
        }
        if (!contactDto.getBirthdate().isEmpty()) {
            query += " AND c.birthdate = '" + contactDto.getBirthdate() + "'";
        }
        if (!contactDto.getCategory().isEmpty()) {
            query += " AND c.categoryId.categoryId = '" + contactDto.getCategory() + "'";
        }
//        em.close();
//        emf.close();
//        em.createQuery(query).setParameter("firstName" , contactDto.getFirstName());
        em.createQuery(query).setParameter("userId" , user);
                return em.createQuery(query).getResultList();
//        List<Contact> contacts = em.createQuery(query).getResultList();

//        CriteriaBuilder cb = em.getCriteriaBuilder(); 
        //        
        //        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class); 
        //        Root<Contact> contactRoot = cq.from(Contact.class);        
        //        cq.select(contactRoot);
        //        
        //        cq.where(cb.and
        //                (cb.like(contactRoot.get(Contact_.firstName), '%' + contactDto.getFirstName() + '%')),
        //                (cb.like(contactRoot.get(Contact_.lastName), '%' + contactDto.getLastName()+ '%')) 
        //        );
        //        List<Contact> contacts = em.createQuery(cq).getResultList();
        

//        return contacts;
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
