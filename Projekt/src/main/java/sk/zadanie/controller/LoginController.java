/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.zadanie.model.User;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class LoginController {
    @RequestMapping("/login")
    public String viewLogin() {
        return "login";
    }
}
