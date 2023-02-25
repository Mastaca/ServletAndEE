package com.fdm.AnotherTest;

import javax.security.auth.login.Configuration;

import com.fdm.AnotherTest.Alien;

import jakarta.transaction.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
        Configuration config = new Configuration().setConfiguration();
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        StandardServiceRegistryBuilder standardRegistryBuilder = new StandardServiceRegistryBuilder();
        
        SessionFactory sf = config.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(telusko);
        
        tx.commit();
    }
}
