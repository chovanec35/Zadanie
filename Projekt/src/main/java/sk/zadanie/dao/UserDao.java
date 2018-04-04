package sk.zadanie.dao;

import java.util.List;
import java.util.Map;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.model.Login;
import sk.zadanie.model.User;

public interface UserDao {
   /* public void add(User user);
    public void edit(User user);
    public void delete(int id);
    public User getUser(int id);
    public List getAllUser();*/
    
    public void addNewContact(ContactDto contact, UserDto userDto, int userId);
    public void registration(UserDto user);
    User validateUser(Login login);
    public List<Map<String, Object>> getAllContacts(int userId); //, String fName, String lName, String role
//    User validateName(Login login);
//    User validatePassword(Login login);
//    User validateEmail(Login login);

}
