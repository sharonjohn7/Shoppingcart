package FrontEnd.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BackEnd.Model.InUsers;
import com.niit.BackEnd.Service.UserService;

@Controller
public class BaseController {

	static AnnotationConfigApplicationContext ctx;
	static UserService us;
	
	static{
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.BackEnd");
		ctx.refresh();
		us = (UserService)ctx.getBean("userService");
	}
	
	@ModelAttribute("obj")
	public InUsers getObj(){
		return new InUsers();
	}
	
	@RequestMapping("/")
	public String gohome(){
		return "Index";
	}
	
	@RequestMapping("/add")
	public String goadd(){
		return "AddUser";
	}
	
	@RequestMapping("/saveUser")
	public String goadd1(@ModelAttribute("obj")InUsers u){
		if(us.addUser(u))
			return "Index";
		else
			return "AddUser";
	}
	
	@RequestMapping("/del")
	public String godel(){
		return "DelUser";
	}
	
	@RequestMapping("/delUser")
	public String godel1(HttpServletRequest req){
		int id = Integer.parseInt(req.getParameter("uid"));
		if(us.delUser(id))
			return "Index";
		else
			return "DelUser";
	}
	
	@RequestMapping("/upd")
	public String goupd(){
		return "UpdUser";
	}
	
	@RequestMapping("/updUser")
	public String goupd1(){
		
		return "Index";
	}
	
	@RequestMapping("/viewall")
	public ModelAndView goall(){
		ModelAndView m = new ModelAndView("ViewUsers");
		m.addObject("data", us.getAllUsers());
		return m;
	}
}
