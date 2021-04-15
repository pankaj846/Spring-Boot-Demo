package com.pankaj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@Autowired // don't need to create any class
	CustomerRepo repo; // repo object
	
	@RequestMapping("/")
	public String details() {
		return "form";
	}
	
	
	@RequestMapping("/details") 
	public String form(Customers customers) {
		repo.save(customers);
		return "form";
	}
	
	@RequestMapping("/getdetails")
	public String getdetails() {
		return "viewCustomers"; //.jsp
	}
	
	
	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid) {
		ModelAndView mv = new ModelAndView();
		Customers customers = repo.findById(cid).orElse(null);
		mv.addObject(customers); // use ${customer.cname} in retrieve.jsp
		mv.setViewName("Retrieve"); // set a viewName where retrieve.jsp file will be shown as o/p
		return mv;
		
	}
}
	
	
//	@GetMapping("form")
//	public String form() {
//		return "form";  // form.jsp
//	}
	
//	@PostMapping("getdetails")
//		public String viewdetails(@RequestParam("cid") String cid, 
//				@RequestParam("cname") String cname,
//				@RequestParam("cemail") String cemail, ModelMap modelMap) {
//			
//		modelMap.put("cid", cid);
//		modelMap.put("cname", cname);
//		modelMap.put("cemail", cemail);
//				
//		return "viewCustomers"; // viewCustomers.jsp
//		
//		}	
//	}

