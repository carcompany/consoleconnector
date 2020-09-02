package com.carcompany.consoleconnector;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public abstract class Observable {

	private Subscriber[] subscribers;

	public Observable() {

	}

	/**
	 * 
	 * @param subscriber
	 */
	public void register(Subscriber subscriber) {

	}

	/**
	 * 
	 * @param subscriber
	 */
	public void unregister(Subscriber subscriber) {

	}

	protected void notifySubscribers() {

	}
}