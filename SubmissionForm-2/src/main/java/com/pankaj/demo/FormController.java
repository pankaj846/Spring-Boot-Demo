package com.pankaj.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers(){
		return repo.findAll();
	}
	
	@RequestMapping("/customers/{cid}")  // cutomer/2
	@ResponseBody
	public Optional<Customers> getCustomers2(@PathVariable("cid") int cust_id){
		return repo.findById(cust_id);
	}
	
	
	// PostMapping used to create customers
	@PostMapping("/customers")	
	public Customers getCustomers3(@RequestBody Customers customers){
		repo.save(customers);
		return customers;
	}
	
	
	
	@DeleteMapping("/customers/{cid}")
	@ResponseBody
	public Customers getCustomers4(@PathVariable("cid") int cust_id){
		Customers cust = repo.getOne(cust_id);
		repo.delete(cust);
		return cust;		
	}
	
	// update customers
	@PutMapping("/customers")
	public Customers getCustomers5(@RequestBody Customers customers){
		repo.save(customers);
		return customers;		
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

