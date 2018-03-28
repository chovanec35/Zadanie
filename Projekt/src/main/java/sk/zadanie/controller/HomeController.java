package sk.zadanie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String viewHome() { 
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
