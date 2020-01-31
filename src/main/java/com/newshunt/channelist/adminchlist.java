package com.newshunt.channelist;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newshunt.daomodel.ChannelDao;
import com.newshunt.daomodel.Signup;
@Controller
public class adminchlist {
	@RequestMapping("/achannel")
	public String add()
	{
		return "adminchannellist";
	}
	@RequestMapping(value="/clist",method=RequestMethod.POST)
	@ResponseBody
	public List<ChannelDao> alist()
	{
		try {
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
        Session s = session.openSession();
        Criteria cs=s.createCriteria(ChannelDao.class);
        List<ChannelDao> p=cs.list();
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
	@RequestMapping(value="/ud" , method=RequestMethod.POST)
	@ResponseBody
	public byte update(@RequestBody ChannelDao e)
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
	@RequestMapping(value="/del" , method=RequestMethod.POST)
	@ResponseBody
	public void del(@RequestBody ChannelDao rec)
	{
	Configuration cfg= new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
	Session ss = sf.openSession();	    
	Criteria criteria = ss.createCriteria(Signup.class);
	List<Signup>info =criteria.list();
	for(Signup w : info) {
		String updateChannel="";
		if(w.getMychannel().contains(rec.getId()+""));
		{
	       String m[] = w.getMychannel().split(",");		
	       for(String v: m) {
	    	   if(v.equals(rec.getId()+"")){
	    		    continue;
	    	   }
	    	   else {
	    		   updateChannel = updateChannel + v +",";    
	    	   }
	       }
	       w.setMychannel(updateChannel);
	       ss.update(w);      
		}
	}
	ss.delete(rec);
	ss.beginTransaction().commit();
	}
	@RequestMapping("/users")
	public String userlist()
	{
		return "userlis";
	}
	@RequestMapping(value="/ulist",method=RequestMethod.POST)
	@ResponseBody
	public List<Signup> user()
	{
		try {
	     Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory session = cfg.buildSessionFactory();
        Session s = session.openSession();
        Criteria cs=s.createCriteria(Signup.class);
        List<Signup> p=cs.list();
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
	@RequestMapping(value="/deleteuser" , method=RequestMethod.POST)
	@ResponseBody
	public byte deleteuser(@RequestBody Signup e)
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
	@RequestMapping(value="/updateuser" , method=RequestMethod.POST)
	@ResponseBody
	public byte updateuser(@RequestBody Signup e)
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
	

}
