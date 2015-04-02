package com.app.mvn.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mvn.example.core.model.Employee;
import com.app.mvn.example.core.model.User;
import com.app.mvn.example.core.service.EmployeeService;
import com.app.mvn.example.core.service.UserService;

/**
 * 使用RestController annotation时，请在配置文件中添加 <mvc:annotation-driven />
 * 
 * 相当于注册了DefaultAnnotationHandlerMapping和AnnotationMethodHandlerAdapter两个bean， 
 * 配置一些messageconverter。即解决了@Controller注解的使用前提配置。
 * @author ke
 *
 */
@RestController
@RequestMapping("/rest")
public class RestfulController {
	
	private static final Log logger = LogFactory.getLog(RestfulController.class);
	private EmployeeService employeeService;
	private UserService userService;
	
	@RequestMapping(value = "/userInfo", produces="application/json")
	public List<Employee> findUserInfo(
			@RequestParam(required = false, defaultValue="xxxx") String userName){
		logger.info(" findUserInfo -> userName = " + userName);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "name1", "last1"));
		list.add(new Employee(2, "name2", "last2"));
		list.add(new Employee(3, "name3", "last3"));
		
		return list;
	}
	
	@RequestMapping(value = "/userXmlInfo", produces="application/xml")
	public List<Employee> findUserXmlInfo(
			@RequestParam(required = false, defaultValue="xxxx") String userName){
		logger.info(" findUserInfo -> userName = " + userName);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "name1", "last1"));
		list.add(new Employee(2, "name2", "last2"));
		list.add(new Employee(3, "name3", "last3"));
		
		return list;
	}
	
	@RequestMapping(value="/findAllUserInfo", produces="application/json")
	public List<Employee> findAllUserInfo(){
		logger.info(" findAllUserInfo ->");
		
		List<Employee> list = employeeService.getAllEmployees();
		
		return list;
		
	}
	
	@RequestMapping(value="/addUserInfo")
	public String addUserInfo(){
		logger.info(" addUserInfo -> ");
		User u = new User();
		u.setId("3");
		u.setAge("10");
		u.setName("xxxx1");
		u.setStandard("Standsxxx");
		u.setSex("man");
		userService.saveUser(u);
		return "succ";
	}

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
}
