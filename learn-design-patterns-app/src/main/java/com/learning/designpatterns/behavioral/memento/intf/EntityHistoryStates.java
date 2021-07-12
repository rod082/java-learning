package com.learning.designpatterns.behavioral.memento.intf;

//playing the role of Caretaker
public interface EntityHistoryStates {

	void add(EntityMemento entityMemento);

	EntityMemento get(int index);

	EntityMemento getLast();
	
	void remove(int index);
	
	void removeLast();
	
	boolean isEmpty();
	
	void clear();

}
