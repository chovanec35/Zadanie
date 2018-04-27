package sk.zadanie.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.entity.Contact;
import sk.zadanie.service.UserService;

@Controller
public class MyController {
    
    @Autowired
    UserService userService;

    @RequestMapping(value = "/ajaxtest")
    public ModelAndView getMainView() {
        ModelAndView mav = new ModelAndView("get-details", "text", "Ahoj tu som");
        Contact contact = userService.getContactById(109);
        mav.addObject("contact", contact);
        return mav;
    }
    
    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody
    String getTime() {
 
        String result = "<h1>AHOOOOOOOOJ</h1>";
        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + result);
        return result;
    }
}
