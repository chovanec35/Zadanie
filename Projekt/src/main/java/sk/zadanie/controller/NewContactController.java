/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
public class NewContactController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/add-new-contact", method = RequestMethod.GET)
    public ModelAndView viewAddNewContact(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("GET");
        ModelAndView mav = new ModelAndView("add-new-contact");
        System.out.println(mav);
        return mav;
    }

    @RequestMapping(value = "/newContactProcess", method = RequestMethod.POST)
    public ModelAndView newContactProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("contact") ContactDto contact) throws IOException {
        userServiceImpl.addNewContact(contact);
        
        return new ModelAndView("add-new-contact");
    }
}




















