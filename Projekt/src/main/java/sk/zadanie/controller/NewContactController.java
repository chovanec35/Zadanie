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
import sk.zadanie.entity.User;
import sk.zadanie.service.CategoryService;
import sk.zadanie.service.UserService;
import sk.zadanie.service.utils.UtilService;

@Controller
@SessionAttributes("loggedUser")
public class NewContactController {

    @Autowired
    UserService userService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    UtilService utilService;
    

    @RequestMapping(value = "/add-new-contact", method = RequestMethod.GET)
    public ModelAndView viewAddNewContact(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("add-new-contact");
        
        mav.addObject("categoryList", categoryService.getAllCategories());
        if (user != null) {
            mav.addObject("user_Id", user.getUserId());
        }else {
            mav.addObject("user_Id", "error");
        }
        return mav; 
    }

    @RequestMapping(value = "/newContactProcess", method = RequestMethod.POST)
    public ModelAndView newContactProcess(@ModelAttribute("contact") ContactDto contactDto, HttpServletRequest request, HttpServletResponse response,
             HttpSession httpSession) throws IOException, ParseException {
        Date date = utilService.convertStringToDate(request.getParameter("birthdate"));
        contactDto.setBirthdate(date);
        System.out.println("conDTO" + contactDto);
        ModelAndView mav = new ModelAndView("redirect:add-new-contact");
        User user = (User) httpSession.getAttribute("loggedUser");
        int userId = user.getUserId();
//        userService.addNewContact(contactDto, userId);
        return mav;
    }
}




















