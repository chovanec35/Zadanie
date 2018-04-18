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
import org.springframework.transaction.annotation.Transactional;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dao.UserDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ContactDao contactDao;

    @Transactional
    public void addNewContact(ContactDto contact, User user, Date date) {
        userDao.addNewContact(contact, user, date);
    }

    @Transactional
    public void registration(UserDto user, Date date) {
        userDao.registration(user, date);
    }

    public User loginUser(LoginDto login) {
        return userDao.loginUser(login);
    }

    public List<Contact> getAllContacts(User user, ContactDto contactDto) throws ParseException {
        return userDao.getAllContacts(user, contactDto);
    }

    public void delContact(int contactId) {
        contactDao.delContact(contactId);
    }

    public Contact getContactById(int contactId) {
        return contactDao.getContactById(contactId);
    }
}
