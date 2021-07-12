package com.learning.designpatterns.behavioral.memento.intf;

public interface Transaction {
	
	void beginTransaction(Entity entity);
	
	void addTransaction(Entity entity);

	void commitTransaction(Entity entity);
	
	void rollback(Entity entity);
	
	Entity getEntity();
}
