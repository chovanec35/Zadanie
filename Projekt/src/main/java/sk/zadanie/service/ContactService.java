/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;

/**
 *
 * @author jchovanec
 */
public interface ContactService {

    public void addNewContact(ContactDto contact, User user, Date date);

    public List<Contact> getAllContacts(User user, ContactDto contactDto, int page) throws ParseException;

    public Contact getContactById(int contactId);
}
