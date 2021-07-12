package com.learning.designpatterns.behavioral.memento.impl;

import com.learning.designpatterns.behavioral.memento.intf.Entity;
import com.learning.designpatterns.behavioral.memento.intf.Transaction;

public class TransactionFactory {

	public static Transaction getTransaction(Entity entity) {
		return TransactionImpl.getInstance(entity);
	}

}
