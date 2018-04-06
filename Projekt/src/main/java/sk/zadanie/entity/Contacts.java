/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.zadanie.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jozef Chovanec
 */
@Entity
@Table(name = "CONTACTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c")
    , @NamedQuery(name = "Contacts.findByContactId", query = "SELECT c FROM Contacts c WHERE c.contactId = :contactId")
    , @NamedQuery(name = "Contacts.findByUserId", query = "SELECT c FROM Contacts c WHERE c.userId = :userId")
    , @NamedQuery(name = "Contacts.findByCategoryId", query = "SELECT c FROM Contacts c WHERE c.categoryId = :categoryId")
    , @NamedQuery(name = "Contacts.findByFname", query = "SELECT c FROM Contacts c WHERE c.fname = :fname")
    , @NamedQuery(name = "Contacts.findByLname", query = "SELECT c FROM Contacts c WHERE c.lname = :lname")
    , @NamedQuery(name = "Contacts.findByDescription", query = "SELECT c FROM Contacts c WHERE c.description = :description")
    , @NamedQuery(name = "Contacts.findByFlagDel", query = "SELECT c FROM Contacts c WHERE c.flagDel = :flagDel")})
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTACT_ID")
    private Integer contactId;
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;
    @Size(max = 50)
    @Column(name = "FNAME")
    private String fname;
    @Size(max = 50)
    @Column(name = "LNAME")
    private String lname;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "FLAG_DEL")
    private Boolean flagDel;

    public Contacts() {
    }

    public Contacts(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(Boolean flagDel) {
        this.flagDel = flagDel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sk.zadanie.entity.Contacts[ contactId=" + contactId + " ]";
    }

}
