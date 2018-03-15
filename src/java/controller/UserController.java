/*
 * Copyright (c) 2018 ELearning Admin
 * All rights reserved.
 * @author thuanenvity
 */
package controller;

import javax.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    public static final String REST_SERVICE_URL = "http://localhost:5000/admin/login/";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap mm) {
        return "login";
    }

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
            ResponseEntity<String>  responseEntity = restTemplate.exchange(REST_SERVICE_URL, HttpMethod.POST, httpEntity, String.class);
        } catch (HttpClientErrorException ex) {
            mm.put("result", "Sai tai khoan mat khau!");
            return "login";
        }
        
        return "login";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(ModelMap mm) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(REST_SERVICE_URL + "?page=1", String.class);
        mm.put("result", result);
        return "login";
    }
}
