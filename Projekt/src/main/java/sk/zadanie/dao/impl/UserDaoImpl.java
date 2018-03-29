package sk.zadanie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sk.zadanie.dao.UserDao;
import sk.zadanie.dto.UserDto;
import sk.zadanie.model.Login;
import sk.zadanie.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    DataSource datasource;
    
    @Autowired
    JdbcTemplate jdbcTemplate;

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
    
    public void registration(UserDto user) {
        System.out.println("zapisujem do DB");
        String sql = "insert into users values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getPassword(), user.getFirstName(),
            user.getLastName(), user.getEmail(), user.getUser_id(), user.getDeleted()});
    }
    
    public User validateUser(Login login) {
        String sql = "select * from users where email='" + login.getEmail()+ "' and password='" + login.getPassword()
                + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }
}

class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setBirthdate(rs.getDate("birthDate"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setFlag_del(rs.getBoolean("flag_del"));
        return user;
    }
}
