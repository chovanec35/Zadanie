package sk.zadanie.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String viewHome(ModelMap model) {
        return "home";
    }

    @RequestMapping("/registration")

    public String viewRegistration() {
        return "registration";
    }

    @RequestMapping("/add-new-contact")
    public String viewAddNewContact() {
        return "add-new-contact";
    }

    @RequestMapping("/my-contacts")
    public String viewMyContacts() {
        return "my-contacts";
    }
}
