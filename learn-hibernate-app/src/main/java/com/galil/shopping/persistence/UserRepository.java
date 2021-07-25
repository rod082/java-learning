package com.galil.shopping.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learning.hibernate.shopping.model.User;

public class UserRepository extends BaseRepository<User> {

	//	public void saveUser(User user) {
	//		Session session = persistenceService.openSession();
	//		Transaction t = session.beginTransaction();
	//		session.save(user);
	//		t.commit();
	//		System.out.println("users is uccessfully saved");
	//	}

	public List<User> getUsers() {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Query<User> query = session.createQuery("SELECT u FROM User u");
		List<User> users = query.list();
		t.commit();
		return users;
	}
}
