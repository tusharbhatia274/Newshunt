package com.newshunt.channelist;
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

import com.newshunt.daomodel.ChannelDao;
import com.newshunt.daomodel.Signup;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
@Controller
public class channellist
{
	
	@RequestMapping("/addchannel")
	public  String chnanel() {
		
		return "addchannel";
	
	}
	@RequestMapping(value="/channel",method=RequestMethod.POST)
	@ResponseBody
	public List<ChannelDao> addChannel(HttpSession se)
	{
		String un = se.getAttribute("un").toString();
		Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
       Session ss = session.openSession();
       Criteria criteria = ss.createCriteria(Signup.class);
	    criteria.add(Restrictions.eq("email_id", un));
       Signup rec = (Signup)criteria.uniqueResult();
       String channel=rec.getMychannel();
       if(channel!=null)
       {
    	   String m[]=channel.split(",");
    	   ArrayList<String> al=new ArrayList<String>();
    	   for(String z:m)
    	   {
    		   al.add(z);
    	   }
    	   Criteria cr=ss.createCriteria(ChannelDao.class);
    	   cr.add(Restrictions.not(Restrictions.in("id", al)) );
    	   List<ChannelDao> pt=cr.list();
    	   if(pt.isEmpty()!=true)
    	   {
    		   return pt;
    	   }
    	   else {
    		   return null;}
       }
       else
       	{
    	   Criteria cr=ss.createCriteria(ChannelDao.class);
    	   List<ChannelDao> pt=cr.list();
    	   if(pt.isEmpty()!=true)
    	   {
    		   return pt;
    	   }
    	   else {
    		   return null;}
       }
	}
	@RequestMapping(value="/subscribe", method = RequestMethod.POST)
	@ResponseBody
	public byte subscribe(@RequestBody Signup r , HttpSession session)
	{
    	try
    	{
    	String un = session.getAttribute("un").toString();
		   Configuration cfg= new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session ss = sf.openSession();
	       Criteria criteria = ss.createCriteria(Signup.class);
	       criteria.add(Restrictions.eq("email_id", un));
           Signup rec = (Signup)criteria.uniqueResult();	       
	       String z=rec.getMychannel();
	       if(z!=null)
	       {
	    	   String x=r.getMychannel();
	    	   String n=z.concat(x);
	    	   rec.setMychannel(n);
	       }
	       else
	       {
	    	   rec.setMychannel(r.getMychannel());
	       }
	       ss.update(rec);
	       ss.beginTransaction().commit();
    	   return 1; 
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	   return 0;
   }
	@RequestMapping("/mychannel")
	public  String mychannel() {
		
		return "mychannel";
	
	}
	@RequestMapping("/subchannel")
	@ResponseBody
	public List<Signup> mchannel(HttpSession session)
	{
		
		String email =session.getAttribute("un").toString();
		Configuration cfg= new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session ss = sf.openSession();
	    Criteria criteria = ss.createCriteria(Signup.class);
	    criteria.add(Restrictions.eq("email_id", email));
        Signup rec = (Signup)criteria.uniqueResult();
        String channel=rec.getMychannel();
        String m[]=channel.split(",");
        ArrayList<String> al=new ArrayList();
        for(String z:m)
        {
        	al.add(z);
        }
		criteria=ss.createCriteria(ChannelDao.class);
		criteria.add(Restrictions.in("id", al));
		List<Signup> subchannel=criteria.list();
	    return subchannel;	
	}
	@RequestMapping(value="/unsubscribe", method = RequestMethod.POST)
	@ResponseBody
	public String unsubscribe(@RequestBody Signup r , HttpSession session)
	{
    	try
    	{
    	String un = session.getAttribute("un").toString();
    		Signup p = new Signup();
		   p.setMychannel(r.getMychannel());
		   Configuration cfg= new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session ss = sf.openSession();
	       Criteria criteria = ss.createCriteria(Signup.class);
	       criteria.add(Restrictions.eq("email_id", un));
           Signup rec = (Signup)criteria.uniqueResult();	       
	       rec.setMychannel(r.getMychannel());
	       ss.update(rec);
	       ss.beginTransaction().commit();
    	   return "Unsubscribed"; 
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	   return "Subscribed";
   }
	@RequestMapping("/favchannel")
	public  String favchannel() {
		
		return "favchannel";
	
	}
	@RequestMapping(value="/fav",method=RequestMethod.POST)
	@ResponseBody
	public List<ChannelDao> fav(HttpSession se)
	{
		String un = se.getAttribute("un").toString();
		Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
       Session ss = session.openSession();
       Criteria criteria = ss.createCriteria(Signup.class);
	    criteria.add(Restrictions.eq("email_id", un));
       Signup rec = (Signup)criteria.uniqueResult();
       String channel=rec.getFavchannel();
       if(channel!=null)
       {
    	   String m[]=channel.split(",");
    	   ArrayList<String> al=new ArrayList<String>();
    	   for(String z:m)
    	   {
    		   al.add(z);
    	   }
    	   Criteria cr=ss.createCriteria(ChannelDao.class);
    	   cr.add(Restrictions.not(Restrictions.in("id", al)) );
    	   List<ChannelDao> pt=cr.list();
    	   if(pt.isEmpty()!=true)
    	   {
    		   return pt;
    	   }
    	   else {
    		   return null;}
       }
       else
       	{
    	   Criteria cr=ss.createCriteria(ChannelDao.class);
    	   List<ChannelDao> pt=cr.list();
    	   if(pt.isEmpty()!=true)
    	   {
    		   return pt;
    	   }
    	   else {
    		   return null;}
       }
	}
	@RequestMapping(value="/favorites", method = RequestMethod.POST)
	@ResponseBody
	public byte Fav(@RequestBody Signup r , HttpSession session)
	{
    	try
    	{
    	String un = session.getAttribute("un").toString();
		   Configuration cfg= new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session ss = sf.openSession();
	       Criteria criteria = ss.createCriteria(Signup.class);
	       criteria.add(Restrictions.eq("email_id", un));
           Signup rec = (Signup)criteria.uniqueResult();	       
	       String z=rec.getFavchannel();
	       if(z!=null)
	       {
	    	   String x=r.getFavchannel();
	    	   String n=z.concat(x);
	    	   rec.setFavchannel(n);
	       }
	       else
	       {
	    	   rec.setFavchannel(r.getFavchannel());
	       }
	       ss.update(rec);
	       ss.beginTransaction().commit();
    	   return 1; 
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	   return 0;
   }
	@RequestMapping("/schannel")
	@ResponseBody
	public List<Signup> channel(HttpSession session)
	{
		
		String email =session.getAttribute("un").toString();
		Configuration cfg= new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session ss = sf.openSession();
	    Criteria criteria = ss.createCriteria(Signup.class);
	    criteria.add(Restrictions.eq("email_id", email));
        Signup rec = (Signup)criteria.uniqueResult();
        String channel=rec.getFavchannel();
        String m[]=channel.split(",");
        ArrayList<String> al=new ArrayList();
        for(String z:m)
        {
        	al.add(z);
        }
		criteria=ss.createCriteria(ChannelDao.class);
		criteria.add(Restrictions.in("id", al));
		List<Signup> subchannel=criteria.list();
	    return subchannel;	
	}

}
