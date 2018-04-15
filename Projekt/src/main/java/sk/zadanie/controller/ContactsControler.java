/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
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
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.UserService;

/**
 *
 * @author Lenovo
 */
@Controller
@SessionAttributes("loggedUser")
public class ContactsControler {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    UserService userService;

    @Autowired
    ContactDao contactDao;

    @RequestMapping(value = "/my-contacts", method = RequestMethod.GET)
    public ModelAndView viewLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("my-contacts");
        mav.addObject("categoryList", categoryDao.getAllCategories());
        return mav;
    }

    @RequestMapping(value = "/searchProcess", method = RequestMethod.POST)
    public ModelAndView searchProcess(HttpServletRequest request,
            HttpServletResponse response, @ModelAttribute("contact") ContactDto contactDto, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");

        List<Contact> contactsList = userService.getAllContacts(user);
        mav.addObject("contactsList", contactsList);
        mav.addObject("user_Id", user.getUserId());
//        if (user != null) {
//            mav.addObject("user_Id", user.getUserId());
//            System.out.println("USER ID ---> " + user.getUserId());
//            List<Contact> contactsList = userService.getAllContacts(user);
        //mav.addObject("contactsList", contactsList);
//            
//        } else {
//            mav.addObject("user_Id", "error");
//        }
        return mav;
    }

    @RequestMapping(params = {"delContact"}, method = RequestMethod.POST)
    public ModelAndView deleteProcess(HttpServletRequest request,
            HttpServletResponse response, @ModelAttribute("contact") Contact contact, HttpSession httpSession) throws IOException, ServletException {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
        String id = request.getParameter("delContact");
        contactDao.delContact(Integer.parseInt(id));

        List<Contact> contactsList = userService.getAllContacts(user);
        mav.addObject("contactsList", contactsList);
        mav.addObject("user_Id", user.getUserId());

        return mav;
    }

    @RequestMapping(params = {"infoContact"}, method = RequestMethod.POST)
    public ModelAndView infoProcess(HttpServletRequest request, HttpServletResponse response, 
            HttpSession httpSession) throws IOException, ServletException {

        String id = request.getParameter("infoContact");
        
        System.out.println("CONTACT --->>>" + id);
//        if ("FirstServlet".equals(action)) 
//        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
//        String id = request.getParameter("delContact");
//        contactDao.delContact(Integer.parseInt(id));
//        
//        List<Contact> contactsList = userService.getAllContacts(user);
//        mav.addObject("contactsList", contactsList);
//        mav.addObject("user_Id", user.getUserId());
//        
//        String[] options = {"OK1","OK2","OK3","OK4"};
        //Integer[] options = {1, 3, 5, 7, 9, 11};
        //Double[] options = {3.141, 1.618};
        //Character[] options = {'a', 'b', 'c', 'd'};
//        int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
//                "Click a button",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
//        System.out.println(x);

        return mav;
    }

}
