package sk.zadanie.dao;

import java.util.Date;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.User;

public interface UserDao {

    public void registration(UserDto user, Date date);

    public User loginUser(LoginDto login);

    public boolean emailExist(UserDto userDto);
}
