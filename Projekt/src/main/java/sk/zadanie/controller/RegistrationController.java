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
import sk.zadanie.dto.UserDto;
import sk.zadanie.model.User;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
public class RegistrationController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView viewRegistration(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("GET");
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("user", new UserDto());
        System.out.println(mav);
        return mav;
    }

    @RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
    public ModelAndView registrationProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("user") UserDto user) throws IOException {
        System.out.println("POST");
        userServiceImpl.registration(user);
        
        return new ModelAndView("registration");
    }
}
