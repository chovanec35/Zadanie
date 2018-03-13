package com.javapointers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jerry on 4/5/14.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String viewHome(){
        return "home";
    }
    
    @RequestMapping("/login")
    public String viewLogin(){
        return "login";
    }
    
    @RequestMapping("/registration")
    public String viewrRegistration(){
        return "registration";
    }
}
