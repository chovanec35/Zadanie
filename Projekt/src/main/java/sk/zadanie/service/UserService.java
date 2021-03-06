/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;

/**
 *
 * @author jchovanec
 */
public interface UserService {

    public void registration(UserDto user, Date date);

    public User loginUser(LoginDto login);

    public boolean emailExist(UserDto userDto);
}
