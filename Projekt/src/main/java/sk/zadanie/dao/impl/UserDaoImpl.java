package sk.zadanie.dao.impl;

import com.sun.jndi.toolkit.ctx.Continuation;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
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
        CriteriaBuilder cb = em.getCriteriaBuilder();  
        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class); 
        Root<Contact> ContactRoot = cq.from(Contact.class);
        
        cq.select(ContactRoot);
        cq.where(cb.equal(ContactRoot.get(contactDto.getFirstName()), "matus"));
        List<Contact> contacts = em.createQuery(cq).getResultList();
        System.out.println("Vysledny zoznam -->" + contacts);

//        String query = "SELECT c FROM Contact c WHERE c.userId = :userId AND c.flagDel=false "
//                + "AND c.firstName LIKE :firstName AND c.lastName LIKE :lastName";
//        
//        if (!contactDto.getBirthdate().isEmpty()) {
//            query += "AND c.birthdate LIKE :birthdate";
//        }
//        if (!contactDto.getCategory().isEmpty()) {
//            query += "AND c.category LIKE :category";
//        }
//        
//        System.out.println("QUERYYY --> " + query);
//        
//        if (contactDto.getCategory() != "" && contactDto.getCategory() != null) {
//            Category category = new Category();
//            category.setCategoryId(Integer.parseInt(contactDto.getCategory()));
//            query.setParameter("categoryId", category);
//        } else if (contactDto.getBirthdate() == "" && contactDto.getCategory() == "") {
//            query = em.createNamedQuery("Contact.findByUserIdWithoutCategory");
//        }
//        if (contactDto.getBirthdate() == ""){
//            Category category = new Category();
//            category.setCategoryId(Integer.parseInt(contactDto.getCategory()));
//            query.setParameter("categoryId", category);
//            
//        } else{
//            Date date = utilService.convertStringToDate(contactDto.getBirthdate());
//            query.setParameter("birthdate", date);
//        }
//        
//
//        query.setParameter("userId", user);
//        query.setParameter("firstName", contactDto.getFirstName() + '%');
//        query.setParameter("lastName", contactDto.getLastName() + '%');
//        query.setParameter("birthdate", date);
//        List<Contact> contacts = (List<Contact>) query.getResultList();
        em.close();
        emf.close();

        return contacts;
//        return null;
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
        if (logins.size() == 0) {
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
    public void addNewContact(ContactDto contactDto, int userId, Date date) {
        String sql = "insert into contacts (FIRST_NAME, LAST_NAME, DESCRIPTION, CATEGORY_ID, USER_ID, BIRTHDATE, CREATION_TS) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{contactDto.getFirstName(),
            contactDto.getLastName(), contactDto.getDescription(), contactDto.getCategory(), userId, date, contactDto.getCreationTs()});
    }
}
