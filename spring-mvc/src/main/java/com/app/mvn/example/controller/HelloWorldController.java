package com.app.mvn.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	private static final Log logger = LogFactory.getLog(HelloWorldController.class);
	
	@RequestMapping("/hello")
	public String helloWorld(Model model){
		logger.info("helloWorld ");
		
		model.addAttribute("message", "helloworld");
		
		return "helloWorld";
	}

}
