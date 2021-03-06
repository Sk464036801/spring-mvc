package com.app.mvn.example.core.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundExample {
	
	@Around("com.xyz.myapp.SystemArchitecture.businessService()")
	  public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
	    // start stopwatch
	    Object retVal = pjp.proceed();
	    // stop stopwatch
	    return retVal;
	  }

}
