package sk.zadanie.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UserDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    
    @Column
    @NotNull
    @NotEmpty
    @Email
    private String email;
    
    @Column
    @NotEmpty
    @NotNull
    private String firstName;
    
    @Column
    @NotEmpty
    @NotNull
    private String lastName;
//    @Column
//     String birthdate;
    
    @Column 
    @Size(min = 8, max = 16)
    @NotEmpty
    private String password;

    @Size(min = 8, max = 16)
    @NotNull
    @NotEmpty
    private String confirmPassword;
    
    @Column
    private boolean deleted;

    public UserDto() {
    }

    public UserDto(int user_id, String email, String firstName, String lastName, String password, boolean deleted, String confirmPassword) {
        this.user_id = user_id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "UserDto{" + "user_id=" + user_id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", deleted=" + deleted + ", confirmPassword=" + confirmPassword + '}';
    }
}
