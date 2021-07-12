package com.learning.designpatterns.behavioral.memento.run;

public class OnlineOrderBuilder {

	public static OnlineOrder build(long id, String name, String status, float val) {
		OnlineOrder order = new OnlineOrder();
		order.setId(id);
		order.setItemName(name);
		order.setStatus(status);
		order.setValue(val);
		return order;
	}
}
