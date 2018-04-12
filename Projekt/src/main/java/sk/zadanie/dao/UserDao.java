package sk.zadanie.dao;

import java.util.List;
import java.util.Map;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.User;

public interface UserDao {
    
    
    
    //User validateUser(Login login);
    public void registration(UserDto user);
    public List<Map<String, Object>> getAllContacts(int userId); //, String fName, String lName, String role
    public User loginUser(LoginDto login);
    public void addNewContact(ContactDto contact, UserDto userDto, int userId);

}
