package sk.zadanie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import sk.zadanie.dao.UserDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.Category;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;

@Repository
@SessionAttributes("loggedUser")
public class UserDaoImpl implements UserDao {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> getAllContacts(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Contact.findByUserId");
        query.setParameter("userId", user);

        List<Contact> contacts = (List<Contact>) query.getResultList();

        em.getTransaction().commit();
        em.close();
        emf.close();

        return contacts;
    }

    @Override
    public void registration(UserDto user) {
        System.out.println("zapisujem do DB" + user.getBirthdate());
        String sql = "insert into users (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, BIRTHDATE) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getFirstName(), user.getLastName(),
            user.getPassword(), user.getEmail(), user.getBirthdate()});
    }

    @Override
    public User loginUser(LoginDto login) {
        String sql = "select * from users where email='" + login.getEmail() + "' and password='" + login.getPassword()
                + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        Query query = em.createNamedQuery("Contact.findByUserId");
//        query.setParameter(1, user);
//        
//        List<Contact> contacts = (List<Contact>) query.getResultList();
//
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        
//        return contacts;
    }

    @Override
    public void addNewContact(ContactDto contactDto, int userId) {
        String sql = "insert into contacts (FIRST_NAME, LAST_NAME, DESCRIPTION, CATEGORY_ID, USER_ID, BIRTHDATE, CREATION_TS) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{contactDto.getFirstName(),
            contactDto.getLastName(), contactDto.getDescription(), contactDto.getCategory(), userId, contactDto.getBirthdate(), contactDto.getCreationTs()});
        
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Date creationTs = new Date();
//        System.out.println("Aktualny cas je: " + dateFormat.format(creationTs));
//        
//        Contact contact = new Contact();
//        contact.setFirstName(contactDto.getFirstName());
//        contact.setLastName(contactDto.getLastName());
//        contact.setBirthdate(contactDto.getBirthdate());
//        Category category = new Category();
//        category.setCategoryId(Integer.parseInt(contactDto.getCategory()));
//        contact.setCategoryId(category);
//        contact.setDescription(contactDto.getDescription());
//        contact.setCreationTs(creationTs);
//        
//        System.out.println("Toto sa zapise do DB --> " + contact);
//        
//        em.persist(contact);
        
        
        
//        Query query = em.createNamedQuery("Contact.addContact");
//        query.setParameter("firstName", contact.getFirstName());
//        query.setParameter("userId", userId);
//        query.setParameter("categoryId", contact.getCategory());
//        query.setParameter("firstName", contact.getFirstName());
//        query.setParameter("lastName", contact.getLastName());
//        query.setParameter("description", contact.getDescription());
//        query.setParameter("creationTs", creationTs);
        

//        em.getTransaction().commit();
//        em.close();
//        emf.close();    
    }
}

class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("USER_ID"));
        user.setFirstName(rs.getString("FIRST_NAME"));
        user.setLastName(rs.getString("LAST_NAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setEmail(rs.getString("EMAIL"));
        user.setBirthdate(rs.getTimestamp("BIRTHDATE"));

        return user;
    }
}
