package com.app.mvn.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tiles")
public class TilesController {
	
	private static final Log logger = LogFactory.getLog(TilesController.class);
	
	@RequestMapping(value="/displayContactInfo")
	public String displayContactInfo(){
		
		logger.info(" displayContactInfo -> ..");
		
		return "displayContactInfo";
	}

}
