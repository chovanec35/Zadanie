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
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.User;
import sk.zadanie.validator.UserValidator;

@Repository
@SessionAttributes("loggedUser")
public class UserDaoImpl implements UserDao {

    @Autowired
    DataSource datasource;

    @Autowired
    UserValidator userValidator;

    @Autowired
    JdbcTemplate jdbcTemplate;

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

}
