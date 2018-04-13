package sk.zadanie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        System.out.println("som v getAllContacts()");
//        List<Contact> contacts = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Contact.findByUserId");
        query.setParameter(1, user);
        
        List<Contact> contacts = (List<Contact>) query.getResultList();
        System.out.println("Dlho ocakavane NamedQuery---> " + query);
        System.out.println("Dlho ocakavane contacts---> " + contacts);

        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return contacts;
    }

    @Override
    public void registration(UserDto user) {
        System.out.println("zapisujem do DB");
        String sql = "insert into users (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL) values(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getFirstName(), user.getLastName(),
            user.getPassword(), user.getEmail()});
    }

    @Override
    public User loginUser(LoginDto login) {
        String sql = "select * from users where email='" + login.getEmail() + "' and password='" + login.getPassword()
                + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public void addNewContact(ContactDto contact, int userId) {
        String sql = "insert into contacts (FIRST_NAME, LAST_NAME, DESCRIPTION, CATEGORY_ID, USER_ID) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{contact.getFirstName(),
            contact.getLastName(), contact.getDescription(), contact.getCategory(), userId});
    }

    /*@Override
    public void add(User user) {
        session.getCurrentSession().save(user);
    }

    @Override
    public void edit(User user) {
        session.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getUser(id));
    }

    @Override
    public User getUser(int id) {
        return (User) session.getCurrentSession().get(User.class, id);
    }

    @Override
    public List getAllUser() {
        return session.getCurrentSession().createQuery("from User").list();
    }*/
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
