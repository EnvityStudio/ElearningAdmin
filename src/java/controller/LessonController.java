/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.reflect.TypeToken;
import static controller.CourseController.REST_SERVICE_URL;
import java.util.List;
import model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import util.GsonUtil;

/**
 *
 * @author thuanenvity
 */
@Controller
@RequestMapping(value = "/course")
public class LessonController {
    
    public static final String REST_SERVICE_URL = "http://localhost:5000/admin/";
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
}
