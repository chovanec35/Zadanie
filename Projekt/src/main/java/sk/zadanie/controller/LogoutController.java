/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.zadanie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Jozef Chovanec
 */
@Controller
@SessionAttributes("loggedUser")
public class LogoutController {

    @RequestMapping(value = "/logoutProcess", method = RequestMethod.GET)
    public String logoutProcess(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "login";
    }
}
