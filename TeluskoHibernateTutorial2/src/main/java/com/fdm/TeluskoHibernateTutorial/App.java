package com.fdm.TeluskoHibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {        
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);        
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sf = config.buildSessionFactory(registry);        
        Session session = sf.openSession();        
        session.beginTransaction();
        
        Alien a1 = (Alien) session.get(Alien.class, 1);
        
        System.out.println(a1.getaName());
        
        session.getTransaction().commit();
        
    }
}
