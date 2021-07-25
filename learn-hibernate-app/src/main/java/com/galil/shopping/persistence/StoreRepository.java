package com.galil.shopping.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learning.hibernate.shopping.model.Store;
import com.learning.hibernate.shopping.model.StoreBranch;

public class StoreRepository extends BaseRepository<Store> {

	public List<StoreBranch> selectBranches() {
		Session session = persistenceService.openSession();
		Transaction t = session.beginTransaction();
		Query<StoreBranch> query = session.createQuery("SELECT b FROM StoreBranch b");
		List<StoreBranch> branchs = query.list();
		t.commit();
		return branchs;
	}
}
