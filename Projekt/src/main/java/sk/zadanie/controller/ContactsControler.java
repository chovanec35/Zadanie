/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dao.CategoryDao;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.CategoryService;
import sk.zadanie.service.UserService;

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

    @RequestMapping(value = "/my-contacts", method = RequestMethod.GET)
    public ModelAndView viewLogin(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
        if (user != null) {
            mav.addObject("categoryList", categoryService.getAllCategories());
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

        if (user != null) {
            List<Contact> contactsList = userService.getAllContacts(user, contactDto);
            mav.addObject("contactsList", contactsList);
            mav.addObject("user_Id", user.getUserId());
            mav.addObject("contactsList", contactsList);

        } else {
            mav.addObject("notFound");
        }
        return mav;
    }

    @RequestMapping(params = {"delContact"}, method = RequestMethod.POST)
    public ModelAndView delContactProcess(HttpServletRequest request,
            HttpServletResponse response, @ModelAttribute("contact") ContactDto contactDto, HttpSession httpSession) throws IOException, ServletException {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
        String id = request.getParameter("delContact");
        contactDao.delContact(Integer.parseInt(id));

        List<Contact> contactsList = userService.getAllContacts(user, contactDto);
        mav.addObject("contactsList", contactsList);
        mav.addObject("user_Id", user.getUserId());

        return mav;
    }

    @RequestMapping(params = {"infoContact"}, method = RequestMethod.POST)
    public ModelAndView infoProcess(HttpServletRequest request, HttpServletResponse response,
            HttpSession httpSession) throws IOException, ServletException {

        int contactId = Integer.parseInt(request.getParameter("infoContact"));

        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");

        Contact contact = userService.getContactById(contactId);
        mav.addObject("user_Id", user.getUserId());

        JOptionPane.showMessageDialog(null, contact.toString(), "Detail Contact", JOptionPane.PLAIN_MESSAGE);

        return mav;
    }

}
