package com.newshunt.menu.controller;

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

import com.newshunt.daomodel.AdminMenuDao;
import com.newshunt.daomodel.ChannelDao;
import com.newshunt.daomodel.MenuDao;
import com.newshunt.daomodel.Signup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
@Controller
public class MenuManagement 
{
	@RequestMapping(value="/menulist",method=RequestMethod.POST)
	@ResponseBody
	public List<MenuDao> menulist()
	{
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
        Session s = session.openSession();
        Criteria cs=s.createCriteria(MenuDao.class);
        List<MenuDao> p=cs.list();
        if(p.isEmpty()!=true)
        {
        	return p;
        }
		return null;
	}
	@RequestMapping(value="/userlistcount",method=RequestMethod.POST)
	@ResponseBody
	public int userlistcount()
	{
		int count=0;
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
        Session s = session.openSession();
        Criteria cs=s.createCriteria(Signup.class);
        List<Signup> p=cs.list();
        for(Signup x:p)
        {
        	count++;
        }
		return count;
	}	
	@RequestMapping(value="/channellistcount",method=RequestMethod.POST)
	@ResponseBody
	public int channellistcount()
	{
		int count=0;
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
        Session s = session.openSession();
        Criteria cs=s.createCriteria(ChannelDao.class);
        List<ChannelDao> p=cs.list();
        for(ChannelDao c:p)
        {
        	count++;
        }
		return count;
	}	
	@RequestMapping(value="/subchannellistcount",method=RequestMethod.POST)
	@ResponseBody
	public int subchannellistcount(HttpSession ss)
	{
		int count=0;
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
         Session s = session.openSession();
         Criteria criteria=s.createCriteria(Signup.class);
         List<Signup> rec=criteria.list();
         for(Signup t:rec)
         {
         String r=t.getMychannel();
         String m[]=r.split(",");
         HashSet<String> al=new HashSet();
         for(String z:m)
        {
        	al.add(z);
        	
        }
        int n=al.size();
		return n ;
         }
         return 0;
	}	
	
	@RequestMapping(value="/amenu",method=RequestMethod.POST)
	@ResponseBody
	public List<AdminMenuDao> menu()
	{
		try {
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
        Session s = session.openSession();
        Criteria cs=s.createCriteria(AdminMenuDao.class);
        List<AdminMenuDao> p=cs.list();
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
	@RequestMapping("/addmenu")
	public String add()
	{
		return "addMenu";
	}
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	@ResponseBody
	public byte menu(@RequestBody MenuDao d)
	{
		 try
		  {
			     Configuration cfg = new Configuration();
				 cfg.configure("hibernate.cfg.xml");
				 SessionFactory session = cfg.buildSessionFactory();
	             Session s = session.openSession();
	             s.save(d);
			     s.beginTransaction().commit();
			    return 1; 
		  }
		  catch(Exception e) {
			  
		  e.printStackTrace();
		  
		  return 0;
		  }
	}
	@RequestMapping("/listmenu")
	public String addlist()
	{
		return "adminmenulist";
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public List<MenuDao> list()
	{
		try {
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
        Session s = session.openSession();
        Criteria cs=s.createCriteria(MenuDao.class);
        List<MenuDao> p=cs.list();
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
	@RequestMapping("/add")
	public String addc()
	{
		return "adminchannel";
	}
	@RequestMapping(value="/adminch" , method=RequestMethod.POST)
	@ResponseBody
	public byte channels(@RequestBody ChannelDao e)
	{
		 try
		  {
			     Configuration cfg = new Configuration();
				 cfg.configure("hibernate.cfg.xml");
				 SessionFactory session = cfg.buildSessionFactory();
	             Session s = session.openSession();
	             s.save(e);
			     s.beginTransaction().commit();
			    return 1; 
		  }
		  catch(Exception f) {
			  
		  f.printStackTrace();
		  
		  return 0;
		  }
	}
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	@ResponseBody
	public byte update(@RequestBody MenuDao e)
	{
		 try
		  {
			     Configuration cfg = new Configuration();
				 cfg.configure("hibernate.cfg.xml");
				 SessionFactory session = cfg.buildSessionFactory();
	             Session s = session.openSession();
	             s.update(e);
			     s.beginTransaction().commit();
			    return 1; 
		  }
		  catch(Exception f) {
			  
		  f.printStackTrace();
		  
		  return 0;
		  }
	}
	@RequestMapping(value="/delete" , method=RequestMethod.POST)
	@ResponseBody
	public byte delete(@RequestBody MenuDao e)
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
