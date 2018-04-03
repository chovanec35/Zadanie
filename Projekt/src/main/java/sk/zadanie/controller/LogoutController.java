/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.zadanie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Jozef Chovanec
 */
@Controller
public class LogoutController {

    @RequestMapping(value = "/logoutProcess", method = RequestMethod.GET)
    public String logoutProcess(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "home";
    }
}
