package com.learning.designpatterns.behavioral.memento.impl;

import java.util.LinkedList;
import java.util.List;

import com.learning.designpatterns.behavioral.memento.intf.EntityHistoryStates;
import com.learning.designpatterns.behavioral.memento.intf.EntityMemento;

//playing the role of Caretaker
public class EntityHistoryStatesImpl implements EntityHistoryStates {

	List<EntityMemento> history = new LinkedList<EntityMemento>();

	public void add(EntityMemento entityMemento) {
		history.add(entityMemento);
	}

	public EntityMemento get(int index) {
		return history.get(index);
	}

	public EntityMemento getLast() {
		return history.size() > 0 ? history.get(history.size() - 1) : null;
	}

	public void remove(int index) {
		history.remove(index);
	}

	public void removeLast() {
		if (history.size() > 0) {
			remove(history.size() - 1);
		}
	}

	public boolean isEmpty() {
		return history.size() == 0;
	}

	public void clear() {
		history.clear();
	}
}
