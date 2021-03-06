package com.app.mvn.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Log logger = LogFactory.getLog(HomeController.class);
	
	@RequestMapping("/")
	public ModelAndView index() {
		logger.info("index ....");
		//创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面
		ModelAndView mav = new ModelAndView("home");
		
		return mav;
	}

}
