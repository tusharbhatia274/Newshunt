package com.newshunt.accountManagement;

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
import com.newshunt.daomodel.feedback;

@Controller
public class help
{

	@RequestMapping(value="/help")
	public String help()
	{
		return "help";
		
	}
	@RequestMapping(value="/feedback" , method=RequestMethod.POST)
	@ResponseBody
	public byte feed(@RequestBody feedback f)
	{
		 try
		  {
			     Configuration cfg = new Configuration();
				 cfg.configure("hibernate.cfg.xml");
				 SessionFactory session = cfg.buildSessionFactory();
	             Session s = session.openSession();
	             s.save(f);
			     s.beginTransaction().commit();
			    return 1; 
		  }
		  catch(Exception e) {
			  
		  e.printStackTrace();
		  
		  return 0;
		  }
	}
	@RequestMapping("/afeedback")
	public String userlist()
	{
		return "adminfeedback";
	}
	@RequestMapping(value="/helpadmin",method=RequestMethod.POST)
	@ResponseBody
	public List<feedback> helpadmin()
	{
		try {
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
        Session s = session.openSession();
        Criteria cs=s.createCriteria(feedback.class);
        List<feedback> p=cs.list();
        if(p.isEmpty()!=true)
        {
        	return p;
        }
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return null;
	}
	@RequestMapping(value="/deletehelp" , method=RequestMethod.POST)
	@ResponseBody
	public byte deletehelp(@RequestBody Signup e)
	{
		 try
		  {
			     Configuration cfg = new Configuration();
				 cfg.configure("hibernate.cfg.xml");
				 SessionFactory session = cfg.buildSessionFactory();
	             Session s = session.openSession();
	             s.delete(e);
			     s.beginTransaction().commit();
			    return 1; 
		  }
		  catch(Exception f) {
			  
		  f.printStackTrace();
		  
		  return 0;
		  }
	}
}
