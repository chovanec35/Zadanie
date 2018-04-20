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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dto.UserDto;
import sk.zadanie.service.UserService;
import sk.zadanie.service.impl.UtilService;
import sk.zadanie.validator.UserValidator;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    UtilService utilService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView viewRegistration(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("title", "Registration");
        return mav;
    }

    @RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
    public ModelAndView registrationProcess(@ModelAttribute("user") UserDto userDto,
            BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("title", "Registration");

        userValidator.validate(userDto, result);
        if (result.hasErrors()) {
            return mav;
        }

        Date date = utilService.convertStringToDate(userDto.getBirthdate());
        
        userService.registration(userDto, date);
        mav = new ModelAndView("login");
        mav.addObject("title", "Login");
        return mav;
    }

}
