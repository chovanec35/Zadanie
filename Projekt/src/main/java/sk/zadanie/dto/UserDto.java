/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.dto;

import java.util.Date;

/**
 *
 * @author Jozef Chovanec
 */
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private Date birthdate;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String email, String password, String confirmPassword, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.birthdate = birthdate;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "UserDto{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", birthdate=" + birthdate + '}';
    }
    

    
}
