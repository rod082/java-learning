package com.learning.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.model.Employee;

public class XmplConfigExampleRunner {
	public static void main(String[] args) {
		
		// method 1:		
		// SessionFactory factory = buildSessionFactory();
		
		// method 2:
		SessionFactory factory = buildSessionFactoryUsingConfiguration();
		
	    Session session = factory.openSession();
	    
		create(session);
		
		session.close();
	}
	
	static SessionFactory buildSessionFactory() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		return factory;
	}
	
	static SessionFactory buildSessionFactoryUsingConfiguration() {
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();
	    return factory;
	}
	
	
	static void create(Session session) {
		Transaction t = session.beginTransaction();
		Employee e1 = new Employee();
		e1.setId(101);
		e1.setFirstName("Muhammad");
		e1.setLastName("Ali");

		session.save(e1);
		t.commit();
		System.out.println("successfully saved");
		//		factory.close();
		//		session.close();
	}
}
