package com.app.mvn.example.controller;

import java.beans.PropertyEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.app.mvn.example.core.model.Employee;

/**
 * 
 * @author ke
 * 
 * headers:String[] headers一般结合method = RequestMethod.POST使用
 * 
 * params: String[] 访问参数设置，字符数组 例如：userId=id 
 * 
 * @RequestHeader 绑定了 HttpServletRequest 请求头 host 到 Controller 的方法参数。
 * 上面方法的三个参数都将会赋予同一个值，由此我们可以知道在绑定请求头参数到方法参数的时候规则和 
 * @PathVariable 、 @RequestParam 以及 @CookieValue 是一样的，即没有指定绑定哪个参数到方法参数的时候，
 * 在 debug 编译模式下将使用方法参数名作为需要绑定的参数。但是有一点 @RequestHeader 
 * 跟另外三种绑定方式是不一样的，那就是在使用 @RequestHeader 的时候是大小写不敏感的，
 * 即 @RequestHeader(“Host”) 和 @RequestHeader(“host”) 绑定的都是 Host 头信息。
 * 记住在 @PathVariable 、 @RequestParam 和 @CookieValue 中都是大小写敏感的
 * 
 * 
 * 支持的返回类型
 * （1 ）一个包含模型和视图的ModelAndView 对象。
 * （2 ）一个模型对象，这主要包括Spring 封装好的Model 和ModelMap ，以及java.util.Map ，
 * 当没有视图返回的时候视图名称将由RequestToViewNameTranslator 来决定。
 * （3 ）一个View 对象。这个时候如果在渲染视图的过程中模型的话就可以给处理器方法定义一个模型参数，
 * 然后在方法体里面往模型中添加值。
 * （4 ）一个String 字符串。这往往代表的是一个视图名称。这个时候如果需要在渲染视图的过程中需要模型的话
 * 就可以给处理器方法一个模型参数，然后在方法体里面往模型中添加值就可以了。
 * （5 ）返回值是void 。这种情况一般是我们直接把返回结果写到HttpServletResponse 中了，
 * 如果没有写的话，那么Spring 将会利用RequestToViewNameTranslator 来返回一个对应的视图名称。
 * （6 ）如果处理器方法被注解@ResponseBody 标记的话，那么处理器方法的任何返回类型都会通过
 * HttpMessageConverters 转换之后写到HttpServletResponse 中，而不会像上面的那些情况一样当做
 * 视图或者模型来处理。如果视图中需要模型的话，处理方法与返回字符串的情况相同。
 * （7 ）除以上几种情况之外的其他任何返回类型都会被当做模型中的一个属性来处理，而返回的视图还是由
 * RequestToViewNameTranslator 来决定，添加到模型中的属性名称可以在该方法上用
 * @ModelAttribute(“attributeName”) 来定义，否则将使用返回类型的类名称的首字母小写形式来表示。
 * 使用@ModelAttribute 标记的方法会在@RequestMapping 标记的方法执行之前执行。
 *
 *
 * SpringMVC 支持使用 @ModelAttribute 和 @SessionAttributes 在不同的模型和控制器之间共享数据。
 *  @ModelAttribute 主要有两种使用方式，一种是标注在方法上，一种是标注在 Controller 方法参数上。
 *  
 *  当 @ModelAttribute 标记在方法上的时候，该方法将在处理器方法执行之前执行，然后把返回的对象存放在 session 
 *  或模型属性中，属性名称可以使用 @ModelAttribute(“attributeName”) 在标记方法的时候指定，
 *  若未指定，则使用返回类型的类名称（首字母小写）作为属性名称。
 *
 */
@Controller
@RequestMapping("/province") //该类下的所有访问路径都在/province之下
@SessionAttributes(value={"userName", "age", "employee"})
public class ProvinceController {
	
	private static final Log logger = LogFactory.getLog(ProvinceController.class);
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(@RequestParam(required= true) String userName,
			@RequestParam(required= false, defaultValue="123456") String password){
		logger.info(" add -> userName = " + userName + ", password = " + password);
		return "home";
	}
	
	@RequestMapping
	public String defaultAction(Model model){
		logger.info(" == defaultAction ==");
		return "home";
	}
	
	@RequestMapping(value="/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(Model model){
		logger.info(" == delete ==");
		
		return "home";
	}
	
	/**
	 * @PathVariable用于方法中的参数，表示方法参数绑定到地址URL的模板变量
	 * 
	 * @PathVariable用于地址栏使用{xxx}模版变量时使用。
	 * 如果@RequestMapping没有定义类似"/{ownerId}" ，这种变量，则使用在方法中@PathVariable会报错。
	 * 
	 * @param ownerId
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping(value="/findOwner/{ownerId}", method=RequestMethod.GET)
	public String findOwner(@PathVariable String ownerId, Model model){
		logger.info("findOwner ownerId = " + ownerId);
		return "home";
	}
	
	/**
	 * @RequestMapping params的补充说明，你可以通过设置参数条件来限制访问地址
	 * 
	 * 例如params="myParam=myValue"表达式，访问地址中参数只有包含了该规定的值"myParam=myValue"才能匹配得上，类似"myParam"之类的表达式也是支持的，表示当前请求的地址必须有该参数(参数的值可以是任意)，"!myParam"之类的表达式表明当前请求的地址不能包含具体指定的参数"myParam"。
	 * 
	 * 如果为类定义了访问地址为*.do,*.html之类的，则在方法级的@RequestMapping，不能再定义value值，否则会报错
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/queryList", method=RequestMethod.GET, params={"query=list"})
	public String queryList(Model model){
		logger.info("queryList ->>");
		return "home";
	}
	
	@RequestMapping(value="/responseMessage", method={RequestMethod.GET})
	@ResponseBody
	public String responseMessage(String userName){
		logger.info("responseMessage userName = " + userName);
		return userName;
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public String findAll(Model model){
		logger.info(" findAll ->");
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee(1,"name1","last1"));
		list.add(new Employee(2,"name2","last2"));
		list.add(new Employee(3,"name3","last3"));
		
		model.addAttribute("employees", list);
		return "employee/list";
	}
	
	@RequestMapping("/displayCookieInfo")
	public String displayCookieInfo(@CookieValue("JSESSIONID") String cookie) {
	    logger.info("displayHeaderInfo cookie = " + cookie);
		return "home";
	}
	
	@RequestMapping("/displayHeaderInfo")
	public String displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding,
	        @RequestHeader(value = "User-Agent:", required = false, defaultValue="xxxx") String userAgent) {
	    logger.info("displayHeaderInfo encoding = " + encoding + ", "
	    		+ "userAgent = " + userAgent);
		return "home";
	}
	
	@RequestMapping(value="/displayAllHeaderInfo")
	public String displayAllHeaderInfo(@RequestHeader Map<String,String> headerMap){
		logger.info(" displayAllHeaderInfo ->");
		Set<String> sets = headerMap.keySet();
		for(String key : sets){
			logger.info(" key = " + key + ", value = " + headerMap.get(key));
		}
		return "home";
	}
	
	@ModelAttribute("userName")
	public String getUserName(){
		logger.info(" getUserName ->>");
		return "userName:xxxx";
	}
	
	@ModelAttribute("age")
	public int getAge(){
		logger.info("getAge ->");
		return 10;
	}
	
	@ModelAttribute("employee")
	public Employee getEmployee(){
		logger.info(" getEmployee ->");
		return new Employee(1,"sk","shang");
	}
	
	
	@RequestMapping(value="/userInfo")
	public String queryUserInfo(@ModelAttribute("userName") String userName,
			@ModelAttribute("age") int age, 
			@ModelAttribute("employee") Employee employee,
			HttpSession session){
		
		logger.info(" queryUserInfo userName = " + userName + ", age = " + 
		age + ", empInfo = " + employee.toString());
		
		Enumeration<String> enume = session.getAttributeNames();  
	       while (enume.hasMoreElements()) {
	    	   logger.info(enume.nextElement() + "\r" );
	       } 
		
		return "home";
	}
	
	@RequestMapping("/sessionInfo")
	public String qeurySessionInfo(@ModelAttribute("userName") String userName,
			@ModelAttribute("age") int age,
			@ModelAttribute("employee") Employee empInfo){
		
		logger.info(" qeurySessionInfo userName = " + userName + ", age = " + age + 
				", empInfo = " + empInfo.toString());
		
		return "home";
	}
	
	@InitBinder
	public void dataBinder(WebDataBinder binder){
		
		DateFormat dateFormat = new SimpleDateFormat( "yyyyMMdd" );  
	       PropertyEditor propertyEditor = new CustomDateEditor(dateFormat, true ); // 第二个参数表示是否允许为空  
	       binder.registerCustomEditor(Date. class , propertyEditor);  
	}
	
	@RequestMapping("/dateInfo/{date}")
	public String dateInfo(@PathVariable Date date){
		
		return "home";
	}
	
	@RequestMapping(value = "/bodyInfo", method=RequestMethod.PUT)
	@ResponseBody
	public String bodyInfo(@RequestBody String body){
		logger.info(" bodyInfo -> " + body);
		return body;
	}
	
	@RequestMapping(value = "/redirectInfo")
	public String redirectInfo(
			@ModelAttribute("userName") String userName,
			BindingResult result, 
			RedirectAttributes redirectAttr){
		logger.info(" redirectInfo ->");
		redirectAttr.addFlashAttribute("userName", "shangkeXX");
		redirectAttr.addAttribute("userName", "shangkeXX11");
		return "redirect:redirectInfo2";
	}
	
	@RequestMapping("/redirectInfo2")
	public String redirectInfo2(RedirectAttributes redirectAttr){
		logger.info(" redirectInfo2 ->");
		Map<String,?> map = redirectAttr.getFlashAttributes();
		logger.info(" redirectInfo2 -> userName = " + map.get("userName"));
		return "redirect:/index.html";
	}
	
	@RequestMapping("/forwardInfo")
	public String forwardInfo(){
		logger.info(" forwardInfo ->");
		return "forward:/app/province/userInfo";
	}
	
	@RequestMapping("/uploadFile")
	public String uploadFile(){
		
		logger.info(" uploadFile ->");
		
		return "upload/uploadFile";
	}
	
	

}
