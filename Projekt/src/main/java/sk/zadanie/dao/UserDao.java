package sk.zadanie.dao;

import java.util.List;
import java.util.Map;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.UserDto;

public interface UserDao {
    
    public void addNewContact(ContactDto contact, UserDto userDto, int userId);
    public void registration(UserDto user);
    //User validateUser(Login login);
    public List<Map<String, Object>> getAllContacts(int userId); //, String fName, String lName, String role


}
