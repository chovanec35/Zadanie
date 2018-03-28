/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.model.Login;
import sk.zadanie.model.User;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
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
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") Login login) {
        ModelAndView mav = null;
        User user = userServiceImpl.validateUser(login);
        System.out.println(user);
        if (user != null) {
            mav = new ModelAndView("my-contacts");
            mav.addObject("id", user.getId());
            mav.addObject("firstName", user.getFirstName());
            mav.addObject("lastName", user.getLastName());
            mav.addObject("email", user.getEmail());
            mav.addObject("password", user.getPassword());
            mav.addObject("birthdate", user.getBirthdate());

        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong!!");
        }

        return mav;
    }
}
