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
    	Alien a = null;
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);        
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();        
        SessionFactory sf = config.buildSessionFactory(registry);        
        Session session = sf.openSession();        
        session.beginTransaction();
        
        Random random = new Random();        
        
//        for (int i =1; i <= 50; i++) {
//        	Student s = new Student();
//        	s.setRollno(i);
//        	s.setName("Name " + i);
//        	s.setMarks(random.nextInt(100));
//        	session.save(s);
//        }
        
        
        
//        {// NATIVE QUERIES - USING SQL LANGUAGE FOR GETTING PARTS OF INFORMATION OF A STUDENT
//        	SQLQuery query = session.createSQLQuery("select name, marks from student where marks > 60");
//        	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//        	List students = query.list();
//        	for (Object o : students) {
//        		Map m = (Map) o;
//        		System.out.println(m.get("name") + " : " + m.get("name"));
//        	}
//        }
        
//        {// NATIVE QUERIES - USING SQL LANGUAGE FOR GETTING ALL INFORMATION OF A STUDENT
//        	SQLQuery query = session.createSQLQuery("select * from student where marks > 60");
//        	query.addEntity(Student.class);
//        	List<Student> students = query.list();
//        	for (Student s : students) {
//        		System.out.println(s);
//        	}
//        }
    	
//        {	
//        	int b = 60;
//        	Query q = session.createQuery("select sum(marks) from Student s where s.marks > :b");
//        	q.setParameter("b", b);
//        	Long marks = (Long)q.uniqueResult();	        
//        	System.out.println(marks);	        
//        }
        
//        {
//        	Query q = session.createQuery("select sum(marks) from Student s where s.marks > 60");
//        	Long marks = (Long)q.uniqueResult();	        
//        	System.out.println(marks);	        
//        }
        
//        {
//        	Query q = session.createQuery("select rollno, name from Student s where s.marks > 60");
//	        List<Object[]> students = (List<Object[]>)q.list();        
//	        for (Object[] student : students) {
//	        	System.out.println(student[0] + " : " + student[1]);
//	        }
//        }
        
//        {
//        	Query q = session.createQuery("select rollno, name from Student");
//	        List<Object[]> students = (List<Object[]>)q.list();        
//	        for (Object[] student : students) {
//	        	System.out.println(student[0] + " : " + student[1]);
//	        }
//    	}
        
//        Object[] students = (Object[])q.uniqueResult();
//        System.out.println(student[0] + " : " + student[1]);
//        for(Object o : student) {
//        	System.out.println(o);
//        }
        
//        {
	//        Student student = (Student)q.uniqueResult();
	//        System.out.println(student);
	        
	//        List<Student>students = q.list();
	//        for (Student s: students) {
	//        	System.out.println(s);
	//        }
//    	}
        
        session.getTransaction().commit();
        session.close();        
        
    }
}
