package com.learning.designpatterns.behavioral.observer;

public class SmsNotificationSubscriber implements Subscriber {

	public void update(String message) {
		System.out.println("SMS recieved.. , message: " + message);
	}

}