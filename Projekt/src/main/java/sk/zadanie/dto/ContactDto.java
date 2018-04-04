package sk.zadanie.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contact_id;
    @Column
    private String role;
    @Column
    private String user_id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String description;

    public ContactDto() {
    }

    public ContactDto(int contact_id, String role, String user_id, String firstName, String lastName, String description) {
        this.contact_id = contact_id;
        this.role = role;
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ContactDto{" + "contact_id=" + contact_id + ", role=" + role + ", user_id=" + user_id + ", firstName=" + firstName + ", lastName=" + lastName + ", description=" + description + '}';
    }

           
}