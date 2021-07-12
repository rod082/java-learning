package com.learning.designpatterns.behavioral.memento.run;

import com.learning.designpatterns.behavioral.memento.intf.Entity;

public class OnlineOrder implements Entity {

	private long id;
	private String itemName;
	private String status;
	private float value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public Object clone() {
		OnlineOrder newObject = new OnlineOrder();
		newObject.setId(id);
		newObject.setItemName(itemName);
		newObject.setStatus(status);
		newObject.setValue(value);
		return newObject;
	}
	
	@Override
	public String toString() {
		return "OnlineOrder[id:" + id + ", name: " + itemName + ", status: " + status + ", value: " + value + "]";
	}
}
