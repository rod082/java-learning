package com.galil.shopping.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersistenceService {

	private static PersistenceService instance;

	private SessionFactory sessionFactory;

	private PersistenceService() {
	}

	private void init() {
		sessionFactory = buildSessionFactory();
	}

	public Session openSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

	public Session getCurrentSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	private SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure("new-hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}

	public static PersistenceService getInstance() {

		if (instance == null) {
			synchronized (PersistenceService.class) {
				if (instance == null) {
					instance = new PersistenceService();
					instance.init();
				}
			}
		}
		return instance;
	}

}
