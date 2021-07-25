package com.galil.shopping.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learning.hibernate.shopping.model.Cart;
import com.learning.hibernate.shopping.model.Customer;

public class CartRepository extends BaseRepository<Cart> {

	public Cart selectById(long id) {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Query<Cart> query = session.createQuery("SELECT c FROM Cart c WHERE c.id = :id").setLong("id", id);
		Cart cart = query.getSingleResult();
		t.commit();
		return cart;
	}
	
	public Cart select(Customer customer) {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Query<Cart> query = session.createQuery("SELECT c FROM Cart c WHERE c.customer = :customer");
		query.setParameter("customer", customer);
		Cart cart = query.getSingleResult();
		t.commit();
		return cart;
	}
}
