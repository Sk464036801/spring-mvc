package com.app.mvn.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.mvn.example.core.service.EmployeeService;

@Controller
public class UserController {
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	private EmployeeService employeeService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(String userName, String password) {
		logger.info("login userName = " + userName);
		employeeService.getAllEmployees();
		if (checkParams(new String[]{userName, password})) {
			ModelAndView mav = new ModelAndView("succ");
			
			mav.addObject("userName", userName);
			mav.addObject("password",password);
			
			return mav;
		}
		
		return new ModelAndView("home");
	}
	
	/*@RequestMapping(value="login",method=RequestMethod.POST)  
	public ModelAndView login(String userName
			,String password,HttpServletRequest request){
		
		employeeService.getAllEmployees();
		
	    request.setAttribute("userName", userName);  
	    request.setAttribute("password", password);  
	    return new ModelAndView("succ");  
	}*/ 

	
	/*** 
     * 验证参数是否为空 
     * @param params 
     * @return 
     */  
    private boolean checkParams(String[] params){  
        for(String param:params){  
            if(param==""||param==null||param.isEmpty()){  
                return false;  
            }  
        }  
        return true;  
    }


    @Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
    
    
}
