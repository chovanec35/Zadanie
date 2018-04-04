/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sk.zadanie.dto.UserDto;
import sk.zadanie.model.Login;
import sk.zadanie.service.impl.RegistrationValidator;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
public class RegistrationController {

    @Autowired
    UserServiceImpl userServiceImpl;

    //PasswordValidator passwordValidator;

    //public static final String REGISTRATION_FORM = "user";

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView viewRegistration(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("user", new UserDto());
        return mav;
    }

    @RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
    public ModelAndView registrationProcess(@ModelAttribute("user") UserDto userDto, 
            BindingResult result) throws IOException {
        System.out.println("Chcem overit vstupy");
        RegistrationValidator registrationValidator = new RegistrationValidator();
        registrationValidator.validate(userDto, result);

        if (result.hasErrors()) {
            System.out.println("Padol som do errors");
            return new ModelAndView("registration", "user", userDto);
        }
        System.out.println("Chcem zapisat do DB");
        userServiceImpl.registration(userDto);
        return new ModelAndView("Login", "user", userDto);
    }
}
