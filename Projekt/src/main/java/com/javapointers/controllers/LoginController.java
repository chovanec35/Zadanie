/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javapointers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jchovanec
 */

@Controller
public class LoginController {
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(){
        return"login";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam String email){ 
        return"welcome";
    }
}
