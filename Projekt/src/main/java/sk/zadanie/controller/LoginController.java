/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;                   
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import sk.zadanie.entity.Login;
import sk.zadanie.entity.User;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
@SessionAttributes("loggedUser")
public class LoginController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView viewLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, 
            HttpServletResponse response, @ModelAttribute("login") Login login, HttpSession httpSession) {
        User user = userServiceImpl.validateUser(login);
        ModelAndView mav = null;
        
        if (user != null && !user.isDeleted()) {    
            httpSession.setAttribute("loggedUser", user);
            mav = new ModelAndView("my-contacts");
            mav.addObject("user_Id",user.getUser_id());
            mav.addObject("email", user.getEmail());
            mav.addObject("password", user.getPassword());
            System.out.println(user.toString());
        } else if (user != null && user.isDeleted()) {
            mav = new ModelAndView("login");
            mav.addObject("message", "This user is deleted!!");
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }
}
