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
import sk.zadanie.dto.LoginDto;
import sk.zadanie.entity.User;
import sk.zadanie.service.UserService;

@Controller
@SessionAttributes("loggedUser")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView viewLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("title", "Login");
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request,
            HttpServletResponse response, @ModelAttribute("login") LoginDto login, HttpSession httpSession) {
        User user = userService.loginUser(login);
        ModelAndView mav = new ModelAndView("login");
        
        if (user != null) {
            httpSession.setAttribute("loggedUser", user);
            mav = new ModelAndView("redirect:my-contacts");
        } else {
            mav.addObject("message", "Username or Password is wrong!!");
            mav.addObject("title", "Login");
        }
        return mav;
    }
}
