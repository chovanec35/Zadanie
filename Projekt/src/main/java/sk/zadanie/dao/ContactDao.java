package sk.zadanie.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;

public interface ContactDao {

    public void delContact(int contactId);

    public Contact getContactById(int contactId);

    public ContactDto setParamertersNull(ContactDto contact);

    public void addNewContact(ContactDto contact, User user, Date date);

    public List<Contact> getAllContacts(User user, ContactDto contactDto, int page) throws ParseException;
}
