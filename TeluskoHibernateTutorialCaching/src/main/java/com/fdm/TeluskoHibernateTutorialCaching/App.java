package com.fdm.TeluskoHibernateTutorialCaching;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {        
    	Alien a = null;
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);        
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sf = config.buildSessionFactory(registry);        
        Session session1 = sf.openSession();        
        session1.beginTransaction();
        Query q1= session1.createQuery("from Alien where aid=101");
        q1.setCacheable(true);
        
        a = (Alien)q1.uniqueResult();
        
//        a= (Alien)session1.get(Alien.class,101);
        System.out.println(a);
        
        session1.getTransaction().commit();
        session1.close();        
        
        Session session2 = sf.openSession();        
        session2.beginTransaction();
        
        Query q2= session2.createQuery("from Alien where aid=101");
        q2.setCacheable(true);
        
//        a= (Alien)session2.get(Alien.class,101);
        System.out.println(a);
        
        session2.getTransaction().commit();
        session2.close();
        
        
    }
}
