/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    

    @Override
    public void register(User user) {
        String sql = "insert into users values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getPassword(), user.getName(),
            user.getName(), user.getEmail(),});
    }

    @Override
    public User validateUser(Login login) {
        String sql = "select * from users where email='" + login.getEmail()+ "' and password='" + login.getPassword()
                + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }
}

class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setName(rs.getString("lastname"));
        user.setPassword(rs.getString("password"));

        user.setEmail(rs.getString("email"));

        return user;
    }
}
