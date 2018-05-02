package sk.zadanie.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.entity.Contact;
import sk.zadanie.service.UserService;

@Controller
public class MyController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getContactDetail(@RequestParam("id") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contact> detail = new ArrayList<>();
        
        int contactId = Integer.parseInt(id);
        Contact contact = userService.getContactById(contactId);
        detail.add(contact);
        
//        System.out.println("ID --> " + request.getParameter("id"));
        System.out.println("Contact" + contact);
        
        map.put("data", detail);
        System.out.println("map " + map);
        return map;
    }
}
