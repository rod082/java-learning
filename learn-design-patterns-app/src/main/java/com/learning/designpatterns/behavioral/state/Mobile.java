package com.learning.designpatterns.behavioral.state;

public class Mobile {

	private MobileState currentState;

	public void setCurrentState(MobileState currentState) {
		this.currentState = currentState;
	}

	public MobileState getCurrentState() {
		return currentState;
	}

	public void alert() {
		System.out.println("alert message is sent..");
		currentState.handleState(this);
	}

	public void showRingingIcon() {
		System.out.println("show ringing Icon.");
	}

	public void showSilentIcon() {
		System.out.println("show silent Icon.");
	}

	public void showRotatingIcon() {
		System.out.println("show rotating Icon.");
	}
}
