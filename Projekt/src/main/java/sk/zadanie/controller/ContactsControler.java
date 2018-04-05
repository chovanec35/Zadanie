/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.model.Login;
import sk.zadanie.model.User;
import sk.zadanie.service.impl.UserServiceImpl;

/**
 *
 * @author Lenovo
 */
@Controller
public class ContactsControler {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/searchProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request,
            HttpServletResponse response, @ModelAttribute("search") Login login, HttpSession httpSession) {

        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView();

        System.out.println("som prihlasenz ako" + user);

        if (user != null) {
            mav.addObject("user_Id", user.getUser_id());
            List<Map<String, Object>> contactsList = userServiceImpl.getAllContacts(user.getUser_id());
            mav.addObject("contactsList", contactsList);

        } else {
            mav.addObject("user_Id", "error");
        }
        return mav;
    }
    
}
