package com.galil.shopping.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learning.hibernate.shopping.model.Customer;
import com.learning.hibernate.shopping.model.CustomerCard;

public class CustomerRepository extends BaseRepository<Customer> {

	public CustomerCard selectCard(Customer customer) {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Query<CustomerCard> query = session.createQuery("SELECT cc FROM CustomerCard cc where cc.customer = :customer");
		query.setParameter("customer", customer);
			CustomerCard cc = query.getSingleResult();
		t.commit();
		return cc;
	}
}