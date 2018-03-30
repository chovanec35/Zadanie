package sk.zadanie.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;
//    @Column
//     String birthdate;
    @Column
    private String password;
    @Column
    private boolean deleted;

    public UserDto() {
    }

    public UserDto(int user_id, String firstName, String lastName, String email, String password, boolean deleted) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.deleted = deleted;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "UserDto{" + "user_id=" + user_id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", deleted=" + deleted + '}';
    }
}
