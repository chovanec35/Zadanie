/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    public List<Contact> getAllContacts(User user, ContactDto contactDto, int page) throws ParseException {
        return contactDao.getAllContacts(user, contactDto, page);
    }

    public Contact getContactById(int contactId) {
        return contactDao.getContactById(contactId);
    }

    @Override
    public void addNewContact(ContactDto contact, User user, Date date) {
        contactDao.addNewContact(contact, user, date);
    }

    public void delContact(int contactId) {
        contactDao.delContact(contactId);
    }
}
