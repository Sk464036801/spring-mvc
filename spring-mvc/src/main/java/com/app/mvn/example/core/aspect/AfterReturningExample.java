package com.app.mvn.example.core.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterReturningExample {
	
	@AfterReturning(
			pointcut="com.app.mvn.example.core.dao.EmployeeDAOImpl.getAllEmployees()",
			returning="retVal")
	  public void doAccessCheck(Object retVal) {
	    // ...
	  }

}
