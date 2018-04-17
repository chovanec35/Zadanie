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
public class ContactDto {

    private String firstName;
    private String lastName;
    private String description;
    private String category;
    private String birthdate;
    private Date creationTs;

    public ContactDto() {
    }

    public ContactDto(String firstName, String lastName, String description, String category, String birthdate, Date creationTs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.category = category;
        this.birthdate = birthdate;
        this.creationTs = creationTs;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Date getCreationTs() {
        return creationTs;
    }

    public void setCreationTs(Date creationTs) {
        this.creationTs = creationTs;
    }

    @Override
    public String toString() {
        return "ContactDto{" + "firstName=" + firstName + ", lastName=" + lastName + ", description=" + description + ", category=" + category + ", birthdate=" + birthdate + ", creationTs=" + creationTs + '}';
    }

}
