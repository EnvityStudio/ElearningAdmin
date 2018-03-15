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
@RequestMapping(value = "/course")
public class CourseController {
    
    /**
     * Method listCourses() shows all courses
     * @param mm
     * @return 
     */
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String listCourses(ModelMap mm) {
        return "courses";
    }
   /**
    * 
    * @param mm
    * @return 
    */
    @RequestMapping (value="/edit",method = RequestMethod.GET)
    public String editCourse(ModelMap mm)
    {
        return "courses";
        
    }
    @RequestMapping (value="/delete",method = RequestMethod.DELETE)
    public String deleteCourse(ModelMap mm)
    {
        return "courses";
    }
    
}
