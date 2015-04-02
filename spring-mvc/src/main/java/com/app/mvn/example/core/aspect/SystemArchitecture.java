package com.app.mvn.example.core.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class SystemArchitecture {
	
	private static final Log logger = LogFactory.getLog(SystemArchitecture.class);
	
	/**
	   * A join point is in the web layer if the method is defined
	   * in a type in the com.xyz.someapp.web package or any sub-package
	   * under that.
	   */
	  @Before(value="within(com.app.mvn.example.controller..*)")
	  @Order(1)
	  public void inWebLayer() {
		  logger.info(" <<<<<<<<<<<<<<<<<<<<<inWebLayer ->");
	  }

	  /**
	   * A join point is in the service layer if the method is defined
	   * in a type in the com.xyz.someapp.service package or any sub-package
	   * under that.
	   */
	  @Pointcut("within(com.xx.app.mvn.example.core.service..*)")
	  public void inServiceLayer() {
		  logger.info(" inServiceLayer ->");
	  }

	  /**
	   * A join point is in the data access layer if the method is defined
	   * in a type in the com.xyz.someapp.dao package or any sub-package
	   * under that.
	   */
	  @Pointcut("within(com.app.mvn.example.core.dao..*)")
	  public void inDataAccessLayer() {
		  logger.info(" inDataAccessLayer ->");
	  }

	  /**
	   * A business service is the execution of any method defined on a service
	   * interface. This definition assumes that interfaces are placed in the
	   * "service" package, and that implementation types are in sub-packages.
	   * 
	   * If you group service interfaces by functional area (for example, 
	   * in packages com.xyz.someapp.abc.service and com.xyz.def.service) then
	   * the pointcut expression "execution(* com.xyz.someapp..service.*.*(..))"
	   * could be used instead.
	   *
	   * Alternatively, you can write the expression using the 'bean'
	   * PCD, like so "bean(*Service)". (This assumes that you have
	   * named your Spring service beans in a consistent fashion.)
	   */
	  @Pointcut("execution(* com.xyz.someapp.service.*.*(..))")
	  public void businessService() {}
	  
	  /**
	   * A data access operation is the execution of any method defined on a 
	   * dao interface. This definition assumes that interfaces are placed in the
	   * "dao" package, and that implementation types are in sub-packages.
	   */
	  @Pointcut("execution(* com.xyz.someapp.dao.*.*(..))")
	  public void dataAccessOperation() {}

}
