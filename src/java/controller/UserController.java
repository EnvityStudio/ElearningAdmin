/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author thuanenvity
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    public static final String REST_SERVICE_URL="http://localhost:5000/Admin";
     @RequestMapping(value = "/login", method = RequestMethod.POST)
     private String login(ModelMap mm)
     {
         System.out.println("login====");
         return "login";
     }
}
