package com.learning.designpatterns.behavioral.observer;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewsPublisherImpl implements NewsPublisher {

	private static NewsPublisher instance = new NewsPublisherImpl();
	
	private List<Subscriber> subscribers = new LinkedList<Subscriber>();

	private String latestNews;

	public static NewsPublisher getInstance() {
		return instance;
	}
	
	private NewsPublisherImpl() {
	}

	public void publish(String news) {
		latestNews = news;
		System.out.println("**publishing latest news: " + latestNews);
		notifySubscribers();
	}

	public String getLatestNews() {
		return latestNews;

	}

	public boolean subscribe(Subscriber subscriber) {
		if (subscriber != null && !subscribers.contains(subscriber)) {
			subscribers.add(subscriber);
			return true;
		}
		return false;
	}

	public boolean unsubscribe(Subscriber subscriber) {
		if (subscriber != null && subscribers.contains(subscriber)) {
			subscribers.remove(subscriber);
			return true;
		}
		return false;
	}

	public Collection<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void notifySubscribers() {
		Iterator<Subscriber> iter = getSubscribers().iterator();
		System.out.println("Updatying all subscribers with latest news message..");
		while (iter.hasNext()) {
			Subscriber sub = iter.next();
			System.out.println(">> Updatying subscriber: " + sub.getClass().getName());
			sub.update(getLatestNews());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
