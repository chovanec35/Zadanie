package sk.zadanie.dao;

import sk.zadanie.dto.UserDto;
import sk.zadanie.model.Login;
import sk.zadanie.model.User;

public interface UserDao {
   /* public void add(User user);
    public void edit(User user);
    public void delete(int id);
    public User getUser(int id);
    public List getAllUser();*/
    
    
    public void registration(UserDto user);
    User validateUser(Login login);
//    User validateName(Login login);
//    User validatePassword(Login login);
//    User validateEmail(Login login);

}
