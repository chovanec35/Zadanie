/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import java.io.IOException;
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
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.User;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
@SessionAttributes("loggedUser")
public class NewContactController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/add-new-contact", method = RequestMethod.GET)
    public ModelAndView viewAddNewContact(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView();
        System.out.println("mav " + mav);
        System.out.println("user " + user);
        if (user != null) {
            mav.addObject("user_Id", user.getUser_id());
        }else {
            mav.addObject("user_Id", "error");
        }
//        ModelAndView mav = new ModelAndView("add-new-contact");
        return mav;
    }

    @RequestMapping(value = "/newContactProcess", method = RequestMethod.POST)
    public ModelAndView newContactProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("contact") ContactDto contact, UserDto userDto, HttpSession httpSession) throws IOException {
        //contact.setRole();
        User user = (User) httpSession.getAttribute("loggedUser");
        int userId = user.getUser_id();
        userServiceImpl.addNewContact(contact, userDto, userId);
        
        
        return new ModelAndView("add-new-contact");
    }
}




















