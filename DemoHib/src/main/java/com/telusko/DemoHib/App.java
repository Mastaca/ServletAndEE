package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien telusko = new Alien();
        telusko.setaId(103);
        telusko.setaName("Harsh");
        telusko.setColor("cyan");
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);        
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        
        SessionFactory sf = config.buildSessionFactory(serviceRegistry);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(telusko);
        
        tx.commit();
        
    }
}
