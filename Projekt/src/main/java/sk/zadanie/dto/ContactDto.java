/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.dto;

import sk.zadanie.entity.Categorie;

/**
 *
 * @author Jozef Chovanec
 */
public class ContactDto {

    private String firstName;
    private String lastName;
    private String description;
    private String category;

    public ContactDto() {
    }

    public ContactDto(String firstName, String lastName, String description, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.category = category;
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

    @Override
    public String toString() {
        return "ContactDto{" + "firstName=" + firstName + ", lastName=" + lastName + ", description=" + description + ", category=" + category + '}';
    }
}
