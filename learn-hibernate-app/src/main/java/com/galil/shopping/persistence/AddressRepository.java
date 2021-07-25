package com.galil.shopping.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.hibernate.shopping.model.Address;

public class AddressRepository extends BaseRepository<Address> {

//	public void saveAddress(Address address) {
//		Session session = persistenceService.openSession();
//		Transaction t = session.beginTransaction();
//		session.save(address);
//		t.commit();
//		System.out.println("address is uccessfully saved");
//	}

}
