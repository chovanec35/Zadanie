package sk.zadanie.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
@SessionAttributes("loggedUser")
public class HomeController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/home")
    public ModelAndView loggUser(HttpSession httpSession) {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

}
