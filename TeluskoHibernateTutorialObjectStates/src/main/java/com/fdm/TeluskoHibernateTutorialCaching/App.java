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
        
        Laptop l = (Laptop) session.get(Laptop.class, 6);
        
        Laptop l2 = (Laptop) session.load(Laptop.class, 6);    	
        
        session.getTransaction().commit();
        session.close();        
        
    }
}
