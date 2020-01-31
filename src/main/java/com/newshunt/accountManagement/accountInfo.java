package com.newshunt.accountManagement;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newshunt.daomodel.Signup;

@Controller
public class accountInfo
{
	@RequestMapping("/accountinfo")
	public  String account() 
	{
		
		return "accountinfo";
	
	}
	@RequestMapping(value="/updation", method = RequestMethod.POST)
	@ResponseBody
	public byte updateinfo(@RequestBody Signup r , HttpSession hs)
	{
		byte flag=0;
    	try
    	{
    	String un = hs.getAttribute("un").toString();
		   Configuration cfg= new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session ss = sf.openSession();
	       Criteria criteria = ss.createCriteria(Signup.class);
	       criteria.add(Restrictions.eq("email_id", un));
           Signup rec = (Signup)criteria.uniqueResult();	       
	       rec.setName(r.getName());
	       rec.setPassword(r.getPassword());
	       rec.setPhno(r.getPhno());
	       ss.beginTransaction().commit();
	       flag=1;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return flag;
	}
	@RequestMapping(value="/fetching", method = RequestMethod.POST)
	@ResponseBody
	public Signup fetchInfo(HttpSession hs)
	{
    	String un = hs.getAttribute("un").toString();
		   Configuration cfg= new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session ss = sf.openSession();
	       Criteria criteria = ss.createCriteria(Signup.class);
	       criteria.add(Restrictions.eq("email_id", un));
           Signup rec = (Signup)criteria.uniqueResult();	       
	       return rec;
	}
}
