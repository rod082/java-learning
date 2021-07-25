package com.learning.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.model.Employee2;

public class AnnotConfigExampleRunner {

	public static void main(String[] args) {
		SessionFactory factory = buildSessionFactory();
		Session session = factory.openSession();
		
		create(session);
		
		session.close();
	}

	static SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}

	static void create(Session session) {
		Transaction t = session.beginTransaction();
		Employee2 e1 = new Employee2();
		e1.setId(102);
		e1.setFirstName("Ahmad");
		e1.setLastName("Othman");

		session.save(e1);
		t.commit();
		System.out.println("successfully saved");
	}
}
