package com.learning.designpatterns.behavioral.observer;

public class ObserverRunner {
	
	public static void main(String[] args) {
		
		Subscriber smsSubs = new SmsNotificationSubscriber();
		Subscriber emailSubs = new EmailNotificationSubscriber();
		
		NewsPublisher publisher = NewsPublisherFactory.getInstance();
		publisher.subscribe(emailSubs);
		publisher.subscribe(smsSubs);
		publisher.publish("News 1");
		
		System.out.println("---------------- After unsubsribe from SNMS Notification ------------------------");
		
		publisher.unsubscribe(smsSubs);
		publisher.publish("News 2");
	}

}
