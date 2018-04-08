/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dao.impl.CategoryDaoImpl;
import sk.zadanie.service.impl.UserServiceImpl;

/**
 *
 * @author Lenovo
 */
@Controller
public class ContactsControler {

    @Autowired
    CategoryDaoImpl categoryDaoImpl;
//    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/my-contacts", method = RequestMethod.GET)
    public ModelAndView viewLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("my-contacts");
        mav.addObject("categoryList", categoryDaoImpl.getAllCategories());
        return mav;
    }
//
//    @RequestMapping(value = "/searchProcess", method = RequestMethod.POST)
//    public ModelAndView loginProcess(HttpServletRequest request,
//            HttpServletResponse response, @ModelAttribute("login") Login login, HttpSession httpSession) {
//        User user = (User) httpSession.getAttribute("loggedUser");
//        ContactDto contact = ContactDto();
//        
//        ModelAndView mav = new ModelAndView();
//        ModelAndView mav1 = new ModelAndView();
//        
//
//        if (user != null) {
//            mav.addObject("user_Id", user.getUser_id());
//            System.out.println("USER ID" + user.getUser_id());
//            System.out.println("mav -> " + mav);
//            List<Map<String, Object>> contactsList = userServiceImpl.getAllContacts(user.getUser_id());
//            mav.addObject("contactsList", contactsList);
//
//        } else {
//            mav.addObject("user_Id", "error");
//        }
//        return mav;
//    }
//}

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
}
