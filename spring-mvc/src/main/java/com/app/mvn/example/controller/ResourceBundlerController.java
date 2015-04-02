package com.app.mvn.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bundle")
public class ResourceBundlerController {
	
	private static final Log logger = LogFactory.getLog(ResourceBundlerController.class);
	
	@RequestMapping(value="/displayWelcom")
	public String displayWelcome(){
		logger.info(" displayWelcome ->");
		return "welcom";
	}

}
