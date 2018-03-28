package sk.zadanie.dao;

import sk.zadanie.model.Login;
import sk.zadanie.model.User;

public interface UserDao {

    public void register(User user);

    User validateUser(Login login);
}
