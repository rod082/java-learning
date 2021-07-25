package com.galil.shopping.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learning.hibernate.shopping.model.Item;

public class ItemRepository extends BaseRepository<Item> {

	public Item selectById(long id) {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Query<Item> query = session.createQuery("SELECT item FROM Item item where item.id = :id").setLong("id", id);
		Item item = query.getSingleResult();
		t.commit();
		return item;
	}

	public Item select(String barcode) {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Query<Item> query = session.createQuery("SELECT item FROM Item item where item.barcode = :barcode")
				.setString("barcode", barcode);
		Item item = query.getSingleResult();
		t.commit();
		return item;
	}
}
