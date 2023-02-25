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
//    	AlienName aName = new AlienName();
//    	aName.setfName("Katyi");
//    	aName.setmName("Gheorghe");
//    	aName.setlName("Eduard");
//    	
//    	Alien telusko = new Alien();
//    	telusko.setaId(101);
//    	telusko.setColor("green");
//    	telusko.setaName(aName);
        
    	Laptop laptop = new Laptop();
    	laptop.setlId(101) ;
    	laptop.setlName("Dell");
    	
    	Student student = new Student();
    	student.setName( "Navin");
    	student.setRollno(1);
    	student.setMrks(50);
    	student.getLaptop().add(laptop);
    	
    	laptop.getStudent().add(student);
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);        
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sf = config.buildSessionFactory(registry);        
        Session session = sf.openSession();        
        session.beginTransaction();
        
        session.save(laptop);
        session.save(student);
        
        session.getTransaction().commit();
        
    }
}
