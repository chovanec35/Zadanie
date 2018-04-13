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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dao.CategoryDao;
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
        System.out.println("Prihlaseny user ---->  " + user);
        ModelAndView mav = new ModelAndView("my-contacts");
//        System.out.println("Hladaj podla -> " + user.getUserId());
//        System.out.println("userService -> " + userService);
        
        List<Contact> contactsList = userService.getAllContacts(user);
        mav.addObject("contactsList", contactsList);
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
}

//
//    @RequestMapping("/my-contacts")
//    public List<ContactDto> showContacts(HttpSession httpSession) {
//        User user = (User) httpSession.getAttribute("loggedUser");
//        int userId = user.getUser_id();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("user_Id", user.getUser_id());
//        
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("from Contacts where id = :id ");
//        query.setParameter("id", 1);
//        List<ContactDto> contacts = query.list();
//        return contacts;
//}
