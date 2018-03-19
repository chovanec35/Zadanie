package sk.db.entities;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int id;
    @Column
    private String name; 
    @Column
    private String email; 
    @Column
    private String birthdate;
    //private Date birthdate;
    @Column
    private String password;

    public User(int id, String name, String email, String birthdate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPassword() {
        return password;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setPassword(String password) {
        this.password = password;
    }          

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", birthdate=" + birthdate + ", password=" + password + '}';
    }
    
    
}
