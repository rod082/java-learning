package com.learning.designpatterns.behavioral.state;

public class MobileRingingState implements MobileState {

	public void handleState(Mobile mobile) {
		System.out.println("Mobile in ringing state..");
		mobile.showRingingIcon();
	}

}
