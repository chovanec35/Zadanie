package sk.zadanie.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.model.User;

@Controller
@SessionAttributes("loggedUser")
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView loggUser(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView();
        if (user != null) {
            mav.addObject("user_Id", user.getUser_id());
        }else {
            mav.addObject("user_Id", "error");
        }
        return mav;
    }
    
    @RequestMapping("/my-contacts")
    public ModelAndView myContactsProcess(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView();
        if (user != null) {
            mav.addObject("user_Id", user.getUser_id());
        }else {
            mav.addObject("user_Id", "error");
        }        
        return mav;
    }


//    @RequestMapping("/my-contacts")
//    public String viewMyContacts() {
//        return "my-contacts";
//    }
}
