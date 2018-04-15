/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.dto;

import java.util.Date;
import sk.zadanie.entity.Category;

/**
 *
 * @author Jozef Chovanec
 */
public class ContactDto {

    private String firstName;
    private String lastName;
    private String description;
    private String category;
    private Date birthdate;

    public ContactDto() {
    }

    public ContactDto(String firstName, String lastName, String description, String category, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "ContactDto{" + "firstName=" + firstName + ", lastName=" + lastName + ", description=" + description + ", category=" + category + ", birthdate=" + birthdate + '}';
    }

    
}
