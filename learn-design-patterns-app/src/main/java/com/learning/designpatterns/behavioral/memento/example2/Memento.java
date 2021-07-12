package com.learning.designpatterns.behavioral.memento.example2;

public class Memento {
	
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
