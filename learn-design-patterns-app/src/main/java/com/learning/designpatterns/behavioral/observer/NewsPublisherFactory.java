package com.learning.designpatterns.behavioral.observer;

public class NewsPublisherFactory {

	public static NewsPublisher getInstance() {
		return NewsPublisherImpl.getInstance();
	}

}
