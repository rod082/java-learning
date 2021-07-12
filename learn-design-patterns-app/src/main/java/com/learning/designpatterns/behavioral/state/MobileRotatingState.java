package com.learning.designpatterns.behavioral.state;

public class MobileRotatingState implements MobileState {

	public void handleState(Mobile mobile) {
		System.out.println("Mobile in rotating state..");
		mobile.showRotatingIcon();
	}

}
