package com.galil.shopping.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public abstract class BaseRepository<T> {

	protected PersistenceService persistenceService;

	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}
	
	protected String getEnityType() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		if (type != null && type.getActualTypeArguments() != null && type.getActualTypeArguments().length > 0) {
			return type.getActualTypeArguments()[0].getTypeName();
		}
		return null;
	}
	
	public Serializable save(Object entity) {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Serializable id = session.save(entity);
		t.commit();
		System.out.println(entity.getClass().getSimpleName() + " is saved uccessfully.");
		return id;
	}
	
	public List<T> selectAll() {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Query<T> query = session.createQuery("SELECT obj FROM " + getEnityType() + " obj");
		List<T> users = query.list();
		t.commit();
		return users;
	}
	
}
