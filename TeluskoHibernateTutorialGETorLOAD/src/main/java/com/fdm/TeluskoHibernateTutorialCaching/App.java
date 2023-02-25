package com.fdm.TeluskoHibernateTutorialCaching;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {        
    	Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);        
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sf = config.buildSessionFactory(registry);        
        Session session = sf.openSession();        
        session.beginTransaction();
        
        Laptop l = new Laptop();
    	l.setId(52);
    	l.setName("Lenovo");
    	l.setPrice(800);
    	
    	session.save(l);
    	
    	l.setPrice(750);
    	
        session.remove(l); // ???
//	    for (int i =1; i <= 50; i++) {
//	    	Laptop l = new Laptop();
//	    	l.setId(i);
//	    	l.setName("Name " + i);
//	    	l.setPrice(i*100);
//	    	session.save(l);
//	    }
        
        session.getTransaction().commit();
        
        session.detach(l); // ????
    	l.setPrice(650);
        
        session.close();        
        
    }
}
