package com.spring.integrate.hibernate.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	String message ="Configuration successful in creation of Spring application";
	
	@RequestMapping("/login")
	public ModelAndView loginMessage(String msg)
	{
		return new ModelAndView("hello", "message", message);		
	}
		
}
