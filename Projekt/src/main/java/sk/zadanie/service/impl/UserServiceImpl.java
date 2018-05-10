/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dao.UserDao;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.User;
import sk.zadanie.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void registration(UserDto user, Date date) {
        userDao.registration(user, date);
    }

    public User loginUser(LoginDto login) {
        return userDao.loginUser(login);
    }

    public boolean emailExist(UserDto userDto) {
        return userDao.emailExist(userDto);
    }
}
