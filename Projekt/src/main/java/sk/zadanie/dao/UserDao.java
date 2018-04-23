package sk.zadanie.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;

public interface UserDao {

    public void registration(UserDto user, Date date);

    public List<Contact> getAllContacts(User user, ContactDto contactDto) throws ParseException; //, String fName, String lName, String role

    public User loginUser(LoginDto login);

    public void addNewContact(ContactDto contact, User user, Date date);

    public boolean emailExist(UserDto userDto);
}
