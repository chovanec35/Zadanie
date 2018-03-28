package sk.zadanie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void register(User user) {
        String sql = "insert into users values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getFirstName(), user.getLastName(), user.getEmail(),
            user.getBirthdate()});
    }

    public User validateUser(Login login) {
        String sql = "select * from users where username='" + login.getEmail()+ "' and password='" + login.getPassword()
                + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }
}

class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setFirstName(rs.getString("first_name"));
        user.setPassword(rs.getString("password"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setPhone(rs.getInt("phone"));
        return user;
    }

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
