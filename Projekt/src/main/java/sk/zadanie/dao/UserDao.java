package sk.zadanie.dao;

import java.util.List;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;

public interface UserDao {

    //User validateUser(Login login);
    public void registration(UserDto user);

    public List<Contact> getAllContacts(User user, ContactDto contactDto); //, String fName, String lName, String role

    public User loginUser(LoginDto login);

    public void addNewContact(ContactDto contact, int userId);

}
