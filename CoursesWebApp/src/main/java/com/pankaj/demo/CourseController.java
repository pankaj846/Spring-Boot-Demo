package com.pankaj.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {

	@RequestMapping("/courses")
	public ModelAndView course(@RequestParam("cname") String courseName) {
		
		ModelAndView mv = new ModelAndView(); // create model view object i.e mv
		mv.addObject("cname", courseName); // use ${cname} in course.jsp
		mv.setViewName("course"); // set a viewName where jsp file will be shown as o/p
		return mv;
	}
	
	
// 	@RequestMapping("/courses")
// 	public String course(String cname, HttpSession session) {
// 		session.setAttribute("cname", cname);  // use ${cname} in course.jsp
// 		return "course"; // .jsp
// 	}
	
	
}
