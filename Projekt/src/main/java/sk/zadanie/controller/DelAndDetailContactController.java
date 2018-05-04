package sk.zadanie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.CategoryService;
import sk.zadanie.service.UserService;

@Controller
@SessionAttributes("loggedUser")
public class DelAndDetailContactController {

    @Autowired
    UserService userService;
    
    @Autowired
    ContactDao contactDao;
    
    @Autowired
    CategoryService categoryService;
    

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteContact(@RequestParam("id") String id, HttpServletRequest request, 
            HttpSession httpSession) throws IOException, ServletException, ParseException {
        System.out.println("SOM V TOM!!!!!!!!!!!!!");
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView("my-contacts");
        ContactDto contactDto = contactDao.setParamertersNull();

        contactDao.delContact(Integer.parseInt(id));

        mav.addObject("categoryList", categoryService.getAllCategories());
        mav.addObject("contactsList", userService.getAllContacts(user, contactDto, 1));
        mav.addObject("user_Id", user.getUserId());
        mav.addObject("title", "Contacts");

        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getContactDetail(@RequestParam("id") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contact> detail = new ArrayList<>();
        
        Contact contact = userService.getContactById(Integer.parseInt(id));
        detail.add(contact);

        map.put("data", detail);
        System.out.println("map " + map);
        return map;
    }
}
