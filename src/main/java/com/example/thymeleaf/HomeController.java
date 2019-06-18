package com.example.thymeleaf;

import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller  
public class HomeController {
	
	
	@Autowired
	private LoginWebService loginWebService;
	
	@RequestMapping("/register" )
	public String register() {
//		model.addAttribute("user", new User());
		return "register";
	}
	
	
//	Login page
    @RequestMapping("/")  
    public String index(){  
        return "index";  
    }  
    
//    after logging in read the entered values like username and password in this case
    @RequestMapping(value="/save", method=RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute User user){  
    	loginWebService.addUser(user);	//added user to database
    	
    	ModelAndView modelAndView = new ModelAndView();  //modelView object 
		modelAndView.setViewName("user_detail");      //
		modelAndView.addObject("user", user); 
//		System.out.println("User info: username-"+user.getUsername()+" Password-"+user.getPassword());
		return modelAndView;  
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user) {
    	User myUser = loginWebService.getUser(user.getUsername());	//
    	
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("welcome_user");
    	modelAndView.addObject("user", myUser);
    	System.out.println("User info: username-"+user.getUsername()+" Password-"+user.getPassword());
    	return modelAndView;
    }
} 
