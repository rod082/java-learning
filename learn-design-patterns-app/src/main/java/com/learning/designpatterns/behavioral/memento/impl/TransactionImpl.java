package com.learning.designpatterns.behavioral.memento.impl;

import com.learning.designpatterns.behavioral.memento.intf.Entity;
import com.learning.designpatterns.behavioral.memento.intf.EntityHistoryStates;
import com.learning.designpatterns.behavioral.memento.intf.EntityMemento;
import com.learning.designpatterns.behavioral.memento.intf.EntityStateException;
import com.learning.designpatterns.behavioral.memento.intf.Transaction;

public class TransactionImpl implements Transaction {

//	public static Transaction instance = new TransactionImpl();
//	public static Transaction getInstance() {
//		return instance;
//	}

	private EntityHistoryStates history;
	private Entity currentEntity;

	public static Transaction getInstance(Entity entity) {
		return new TransactionImpl(entity);
	}

	private TransactionImpl(Entity entity) {
		currentEntity = entity;
		history = new EntityHistoryStatesImpl();
	}

	public void beginTransaction(Entity entity) {
		currentEntity = entity;
		try {
			EntityMemento em = EntityMementoImpl.build(currentEntity);
			history.add(em);
		} catch (EntityStateException e) {
			e.printStackTrace();
		}
	}

	public void addTransaction(Entity entity) {
		currentEntity = entity;
		try {
			EntityMemento em = EntityMementoImpl.build(currentEntity);
			history.add(em);
		} catch (EntityStateException e) {
			e.printStackTrace();
		}
	}

	public void commitTransaction(Entity entity) {
		currentEntity = entity;
		history.clear();
	}

	public void rollback(Entity entity) {
		if (!history.isEmpty()) {
			history.removeLast();
			EntityMemento lastEntityMemento = history.getLast();
			currentEntity = lastEntityMemento.getEntity();
			entity = currentEntity;
		}
	}

	public Entity getEntity() {
		return currentEntity;
	}

}
