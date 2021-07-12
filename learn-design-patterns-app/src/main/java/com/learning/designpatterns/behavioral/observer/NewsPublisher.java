package com.learning.designpatterns.behavioral.observer;

import java.util.Collection;

public interface NewsPublisher {

	void publish(String latestNews);

	String getLatestNews();

	boolean subscribe(Subscriber subscriber);

	boolean unsubscribe(Subscriber subscriber);

	Collection<Subscriber> getSubscribers();

	void notifySubscribers();

}
