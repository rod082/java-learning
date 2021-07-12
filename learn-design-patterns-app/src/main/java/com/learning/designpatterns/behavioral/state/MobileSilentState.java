package com.learning.designpatterns.behavioral.state;

public class MobileSilentState implements MobileState {

	public void handleState(Mobile mobile) {
		System.out.println("Mobile in silent state..");
		mobile.showSilentIcon();
	}

}
