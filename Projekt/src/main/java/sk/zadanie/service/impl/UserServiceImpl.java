/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.zadanie.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.zadanie.dao.UserDao;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.User;
import sk.zadanie.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userDao;
    
//    @Transactional
//    public void addNewContact(ContactDto contact, UserDto userDto, int userId){
//        userDao.addNewContact(contact, userDto, userId);
//    }
//    
    @Transactional
    public void registration(UserDto user){
        userDao.registration(user);
    }
//    
    @Transactional
    public User loginUser(LoginDto login){
        return userDao.loginUser(login);
    }
//
//     @Transactional
//    public List<Map<String, Object>> getAllContacts(int userId){ //, String fName, String lName, String role
//        return userDao.getAllContacts(userId); //, fName, lName, role
//    }
   
}
