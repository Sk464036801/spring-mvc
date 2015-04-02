package com.app.mvn.example.core.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingExample {
	
	@AfterThrowing(
			pointcut="com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	  public void doRecoveryActions() {
	    // ...
	  }

}
