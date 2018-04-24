/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.CategoryService;
import sk.zadanie.service.UserService;
import sk.zadanie.service.impl.UtilService;

/**
 *
 * @author Lenovo
 */
@Controller
@SessionAttributes("loggedUser")
public class ContactsControler {

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @Autowired
    ContactDao contactDao;

    @Autowired
    UtilService utilService;

    @RequestMapping(value = "/my-contacts", method = RequestMethod.GET)
    public ModelAndView viewLogin(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws ParseException {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
        if (user != null) {
            ContactDto contactDto = contactDao.setParamertersNull();
            mav.addObject("contactsList", userService.getAllContacts(user, contactDto));
            mav.addObject("categoryList", categoryService.getAllCategories());
            mav.addObject("title", "Contacts");
            return mav;
        }
        mav = new ModelAndView("not-found");
        return mav;
    }

    @RequestMapping(value = "/searchProcess", method = RequestMethod.POST)
    public ModelAndView searchProcess(@ModelAttribute("contact") ContactDto contactDto, HttpSession httpSession,
            BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
        String dateString = contactDto.getBirthdate();
        if (user != null) {
            List<Contact> contactsList = userService.getAllContacts(user, contactDto);
            mav.addObject("categoryList", categoryService.getAllCategories());
            mav.addObject("contactsList", contactsList);
            mav.addObject("user_Id", user.getUserId());
            mav.addObject("title", "Contacts");
        } else {
            mav.addObject("title", "Not found");
            mav.addObject("not-found");
        }
        return mav;
    }

    @RequestMapping(params = {"delContact"}, method = RequestMethod.POST)
    public ModelAndView contactListProcess(HttpServletRequest request,
            HttpServletResponse response, HttpSession httpSession) throws IOException, ServletException, ParseException {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
        String id = request.getParameter("delContact");
        ContactDto contactDto = contactDao.setParamertersNull();

        contactDao.delContact(Integer.parseInt(id));

        mav.addObject("categoryList", categoryService.getAllCategories());
        mav.addObject("contactsList", userService.getAllContacts(user, contactDto));
        mav.addObject("user_Id", user.getUserId());
        mav.addObject("title", "Contacts");

        return mav;
    }

    @RequestMapping(params = {"infoContact"}, method = RequestMethod.POST)
    public ModelAndView infoProcess(HttpServletRequest request, HttpServletResponse response,
            HttpSession httpSession) throws IOException, ServletException, ParseException {
        ContactDto contactDto = contactDao.setParamertersNull();
        int contactId = Integer.parseInt(request.getParameter("infoContact"));

        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
        mav.addObject("categoryList", categoryService.getAllCategories());

        Contact contact = userService.getContactById(contactId);
        mav.addObject("contactL", contact);
        mav.addObject("contactsList", userService.getAllContacts(user, contactDto));
        mav.addObject("user_Id", user.getUserId());
        mav.addObject("title", "Contacts");
        
        return mav;
    }
//    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json")
//    public @ResponseBody Map<String, Object> infoProcess(Contact contact) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        Contact list = userService.getContactById(1);
// 
//        if (list != null) {
//            map.put("status", "200");
//            map.put("message", "Data found");
//            map.put("data", list);
//        } else {
//            map.put("status", "404");
//            map.put("message", "Data not found");
// 
//        }
// 
//        return map;
//    }

}
