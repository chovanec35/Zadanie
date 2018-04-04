/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Lenovo
 */
@Controller
public class ContactsControler {
    
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
//    }    
}
