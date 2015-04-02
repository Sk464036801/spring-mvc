package com.app.mvn.example.core.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
public class BeforeExample {
	
	private static final Log logger = LogFactory.getLog(BeforeExample.class);

	@Before("execution(* com.app.mvn.example.controller.*.*(..))")
	@Order(2)
	public void doAccessCheck() {
		logger.info(" >>>>>>>>>>>>>>>>>doAccessCheck ->");
	}

	public BeforeExample() {
		logger.info("=================================================");
	}
	
	

}
