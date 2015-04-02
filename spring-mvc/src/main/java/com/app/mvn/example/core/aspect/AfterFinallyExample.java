package com.app.mvn.example.core.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterFinallyExample {
	
	@After("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	  public void doReleaseLock() {
	    // ...
	  }

}
