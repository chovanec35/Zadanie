package sk.zadanie.dao;

import java.util.List;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;

public interface ContactDao {

    public void delContact(int contactId);
    
    public Contact getContactById(int contactId);
    
    public ContactDto setParamertersNull();

}
