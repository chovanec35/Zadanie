package sk.zadanie.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dao.impl.UserDaoImpl;
import sk.zadanie.service.impl.UserServiceImpl;

@Controller
@SessionAttributes("loggedUser")
public class HomeController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/home")
    public ModelAndView loggUser(HttpSession httpSession) {
//        User user = (User) httpSession.getAttribute("loggedUser");
        ModelAndView mav = new ModelAndView();
//        if (user != null) {
//            mav.addObject("user_Id", user.getUser_id());
//        }else {
//            mav.addObject("user_Id", "error");
//        }
        return mav;
    }

}
