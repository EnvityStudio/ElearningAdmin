/*
 * Copyright (c) 2018 ELearning Admin
 * All rights reserved.
 * @author thuanenvity
 */
package controller;

import com.google.gson.reflect.TypeToken;
import static controller.CourseController.REST_SERVICE_URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.Course;
import model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import util.GsonUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    public static final String REST_SERVICE_URL = "http://localhost:5000/admin/";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap mm) {
        return "login";
    }

    /**
     * Method: loginUser()
     *
     * @param mm
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(ModelMap mm, @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            HttpSession session) {
        System.out.println("login====");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("username", username);
        map.add("password", password);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, httpHeaders);
        System.out.println("befor");
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(REST_SERVICE_URL + "login/", HttpMethod.POST, httpEntity, String.class);
        } catch (HttpClientErrorException ex) {
            mm.put("result", "Email or Password is incorrect!");
            return "login";
        }

        return "redirect:../course/courses";
    }

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public String allusers(ModelMap mm) {
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(REST_SERVICE_URL + "allusers/", String.class);
        List<User> listUser = GsonUtil.newInstance().gson().fromJson(json, new TypeToken<List<User>>() {
        }.getType());
        mm.addAttribute("listuser", listUser);

        if (json != null) {

        } else {
            mm.put("result", "No user exist!!!!");
        }
        return "users";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public  String deleteUser(ModelMap mm,@RequestParam(value = "iduser" ,required = true) int idUser) {         
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URL + "delete_user/" + idUser);
        return "redirect:./allusers";
    }

}
