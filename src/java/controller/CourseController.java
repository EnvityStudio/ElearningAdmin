/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.reflect.TypeToken;
import static controller.UserController.REST_SERVICE_URL;
import java.util.LinkedHashMap;
import java.util.List;
import model.Course;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import util.GsonUtil;

/**
 *
 * @author thuanenvity
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController {

    public static final String REST_SERVICE_URL = "http://localhost:5000/admin/";

    /**
     * Method listCourses() shows all courses
     *
     * @param mm
     * @return
     */
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String listCourses(ModelMap mm) {
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(REST_SERVICE_URL+ "courses/", String.class);
        List<Course> listCourse = GsonUtil.newInstance().gson().fromJson(json, new TypeToken<List<Course>>() {
        }.getType());
        mm.addAttribute("listcourse", listCourse);
        System.out.println(json);
        System.out.println(listCourse.get(1).getName());
        if (json != null) {

        } else {
            mm.put("result", "No course exist!!!!");
        }
        return "courses";
    }

    @RequestMapping(value="/insert",method = RequestMethod.GET)
            public String insertCourse(ModelMap mm)
            {
                 System.out.println("Insert=========");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("name","thuaennvity");
        map.add("description","thuanenvity");
        map.add("image", "thuanenvity.png");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, httpHeaders);
        System.out.println("befor");
        try {
            ResponseEntity<String>  responseEntity = restTemplate.exchange(REST_SERVICE_URL +"insertcourse/", HttpMethod.POST, httpEntity, String.class);
        } catch (HttpClientErrorException ex) {
            mm.put("result", "Sai tai khoan mat khau!");
            return "login";
        }
        
                return "login";
            }
    
    /**
     *
     * @param mm
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCourse(ModelMap mm) {
        return "courses";
    }

    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteCourse(ModelMap mm) {
        return "courses";
    }

}
