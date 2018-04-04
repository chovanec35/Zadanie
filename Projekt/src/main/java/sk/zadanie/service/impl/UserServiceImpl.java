/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.zadanie.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.zadanie.dao.UserDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.model.Login;
import sk.zadanie.model.User;
import sk.zadanie.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userDao;
    
    /*@Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    public List getAllUser() {
        return userDao.getAllUser();
    }*/
    
    @Transactional
    public void addNewContact(ContactDto contact, UserDto userDto, int userId){
        userDao.addNewContact(contact, userDto, userId);
    }
    
    @Transactional
    public void registration(UserDto user){
        userDao.registration(user);
    }
    
    @Transactional
    public User validateUser(Login login){
        return userDao.validateUser(login);
    }

    
}
