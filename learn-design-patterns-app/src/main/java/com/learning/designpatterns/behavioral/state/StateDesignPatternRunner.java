package com.learning.designpatterns.behavioral.state;

public class StateDesignPatternRunner {

	public static void main(String[] args) {
		
		Mobile mobile = new Mobile();
		mobile.setCurrentState(new MobileRingingState());
		mobile.alert();
		System.out.println("----------------------------------------");
		mobile.setCurrentState(new MobileSilentState());
		mobile.alert();
		System.out.println("----------------------------------------");
		mobile.setCurrentState(new MobileRotatingState());
		mobile.alert();
	}

}
