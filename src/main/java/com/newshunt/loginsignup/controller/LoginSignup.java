package com.newshunt.loginsignup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.newshunt.daomodel.Signup;

@Controller
public class LoginSignup {

	@RequestMapping("/")
	public  String login() {
		
		return "login";
	
	}
	@RequestMapping("/signup")
	public  String signup() {
		
		return "signup";
	
	}
	@RequestMapping("/saveUserInfo")
	@ResponseBody
	public  byte saveUserInfo(@RequestBody Signup rec) {
		
		  try
		  {
			     Configuration cfg = new Configuration();
				 cfg.configure("hibernate.cfg.xml");
				 SessionFactory session = cfg.buildSessionFactory();
	             Session s = session.openSession();
	             s.save(rec);
			     s.beginTransaction().commit();
			    return 1; 
		  }
		  catch(Exception e) {
			  
		  e.printStackTrace();
		  
		  return 0;
		  }
	}
			@RequestMapping(value="/loginUserInfo",method=RequestMethod.POST)
			@ResponseBody
			public  Byte loginUserInfo(@RequestBody Signup z,HttpSession session)
			{
							
							String un="";
					     Configuration cfg = new Configuration();
						 cfg.configure("hibernate.cfg.xml");
						 SessionFactory ss = cfg.buildSessionFactory();
			             Session s = ss.openSession();
			             Criteria cs=s.createCriteria(Signup.class);
			  	       		List<Signup> p=cs.list();	
			  	       	    Byte f=0;
			  	       		for(Signup m:p)
			  	       		{
			  	       			if(m.getEmail_id().equals(z.getEmail_id()) && m.getPassword().equals(z.getPassword() ))
			  	       			{
			  	       			un=m.getEmail_id();
			  	       				f=1;
			  	       				
			  	       			}
			  	       			else if(z.getEmail_id().equals("admin@123") && z.getPassword().equals("123") )
			  	       			{
			  	       				f=2;
			  	       			}
			  	       		}
			  	       	 session.setAttribute("un", un);
			  		    return f; 
			  	       		
	
	    }
			@RequestMapping("/home")
			public  String home() {
				
				return "home";
			
			}
			

@RequestMapping(value="/adminMenu")
public  String admin() {
	
	return "adminMenu";

}
}