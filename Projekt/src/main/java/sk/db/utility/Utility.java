/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.db.utility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jozef Chovanec
 */
public class Utility {

    private static final Logger log = LoggerFactory.getLogger(Utility.class);

    @Autowired
    JdbcTemplate jdbcTemplate;
    Connection conn;

    public static void main(String[] args) throws SQLException {
        Utility app = new Utility();

        app.connectionToDerby();
        app.createNewUser(3, "Milan", "milan@milan.sk", "DD-MM-YYYY", "rwefgeg");
    }

    public void connectionToDerby() throws SQLException {
        String dbUrl = "jdbc:derby://localhost:1527/DbJozef;create=true";
        
        conn = DriverManager.getConnection(dbUrl);
    }

    public void createNewUser(int id, String name, String email, String birthdate, String password) {

    }
}
