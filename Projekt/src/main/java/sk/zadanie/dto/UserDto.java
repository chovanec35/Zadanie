package sk.zadanie.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    
    @Column
    @NotNull
    private String email;
    
    @Column
    @NotNull
    private String firstName;
    
    @Column
    @NotNull
    private String lastName;
//    @Column
//     String birthdate;
    
    @Column 
    @Size(min = 8, max = 16)
    private String password;

    @Size(min = 8, max = 16)
    @NotNull
    private String confirmPassword;
    
    @Column
    private boolean deleted;

    public UserDto() {
    }

    public UserDto(int userId, String email, String firstName, String lastName, String password, boolean deleted, String confirmPassword) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.deleted = deleted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        return "UserDto{" + "userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", deleted=" + deleted + ", confirmPassword=" + confirmPassword + '}';
    }
}
