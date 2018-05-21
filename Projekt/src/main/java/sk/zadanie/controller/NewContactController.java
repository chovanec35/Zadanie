/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dao.CategoryDao;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.User;
import sk.zadanie.service.CategoryService;
import sk.zadanie.service.UserService;
import sk.zadanie.service.impl.UtilService;

@Controller
@SessionAttributes("loggedUser")
public class NewContactController {

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UtilService utilService;

    @Autowired
    CategoryDao categoryDao;
    
    @Autowired
    ContactDao contactDao;

    @RequestMapping(value = "/add-new-contact", method = RequestMethod.GET)
    public ModelAndView viewAddNewContact(HttpServletRequest request, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("add-new-contact");
        if (user != null) {
            httpSession.removeAttribute("contactDto");
            mav.addObject("categoryList", categoryDao.getAllCategories());
            mav.addObject("title", "New Contact");
            return mav;
        }
        mav = new ModelAndView("login");
        mav.addObject("title", "Login");
        return mav;
    }

    @RequestMapping(value = "/newContactProcess", method = RequestMethod.POST)
    public ModelAndView newContactProcess(@ModelAttribute("contact") ContactDto contactDto,
            HttpSession httpSession) throws IOException, ParseException {
        User user = (User) httpSession.getAttribute("loggedUser");

        Date date = null;
        if (!contactDto.getBirthdate().isEmpty()) {
            date = utilService.convertStringToDate(contactDto.getBirthdate());
        } 
        
        ModelAndView mav = new ModelAndView("add-new-contact");
        mav.addObject("title", "New Contact");
        contactDao.addNewContact(contactDto, user, date);
        return mav;
    }
}
