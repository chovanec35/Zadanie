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
import sk.zadanie.dao.CategoryDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.dto.LoginDto;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.User;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
@SessionAttributes("loggedUser")
public class NewContactController {

    @Autowired
    UserServiceImpl userServiceImpl;
    
    @Autowired
    CategoryDao categoryDao;

    @RequestMapping(value = "/add-new-contact", method = RequestMethod.GET)
    public ModelAndView viewAddNewContact(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("add-new-contact");
        mav.addObject("categoryList", categoryDao.getAllCategories());
        if (user != null) {
            mav.addObject("user_Id", user.getUserId());
        }else {
            mav.addObject("user_Id", "error");
        }
        return mav;
    }

    @RequestMapping(value = "/newContactProcess", method = RequestMethod.POST)
    public ModelAndView newContactProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("contact") ContactDto contact, UserDto userDto, HttpSession httpSession) throws IOException {
        //System.out.println("daj kategoriu " + contact.getCategory());
        User user = (User) httpSession.getAttribute("loggedUser");
        String selectedvalue  =  request.getParameter("category");
        System.out.println("selected value " + selectedvalue);
        int userId = user.getUserId();
        userServiceImpl.addNewContact(contact, userDto, userId);
        return new ModelAndView("add-new-contact");
    }
}




















