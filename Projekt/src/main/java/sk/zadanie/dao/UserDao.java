package sk.zadanie.dao;

import sk.zadanie.model.Login;
import sk.zadanie.model.User;

public interface UserDao {
   /* public void add(User user);
    public void edit(User user);
    public void delete(int id);
    public User getUser(int id);
    public List getAllUser();*/
    
    void registration(User user);
    User validateUser(Login login);
}
