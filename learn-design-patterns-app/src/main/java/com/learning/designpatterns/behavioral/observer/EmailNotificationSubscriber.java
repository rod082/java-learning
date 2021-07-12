package com.learning.designpatterns.behavioral.observer;

public class EmailNotificationSubscriber implements Subscriber {

	public void update(String message) {
		System.out.println("Email recieved.. , message: " + message);
	}

}
