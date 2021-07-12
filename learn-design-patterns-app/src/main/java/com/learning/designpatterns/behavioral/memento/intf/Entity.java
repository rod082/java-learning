package com.learning.designpatterns.behavioral.memento.intf;

public interface Entity extends Cloneable {

	Object clone() throws CloneNotSupportedException;
}
