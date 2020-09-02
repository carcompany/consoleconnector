package com.carcompany.consoleconnector;

import java.util.ArrayList;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public abstract class Observable {

	private ArrayList<Subscriber> subscribers;

	public Observable() {
		this.subscribers = new ArrayList<>();
	}

	/**
	 * 
	 * @param subscriber
	 */
	public void register(Subscriber subscriber) {
		this.subscribers.add(subscriber);
	}

	/**
	 * 
	 * @param subscriber
	 */
	public void unregister(Subscriber subscriber) {
		this.subscribers.remove(subscriber);
	}

	protected void notifySubscribers() {
		subscribers.forEach((subscriber) -> {
			subscriber.update();
		});
	}
}