/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.service;

import java.util.List;
import sk.zadanie.dto.UserDto;
import sk.zadanie.model.Login;
import sk.zadanie.model.User;

/**
 *
 * @author jchovanec
 */
public interface UserService {
   /* public void add(User user);
    public void edit(User user);
    public void delete(int id);
    public User getUser(int id);
    public List getAllUser();*/
    public void registration(UserDto user);
    public User validateUser(Login login);
}
