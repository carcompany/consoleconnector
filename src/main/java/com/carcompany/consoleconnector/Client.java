package com.carcompany.consoleconnector;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:41
 */
public class Client {

	public static void main(String[] args) {
		while (true) {
			Dispatcher.getInstance().evaluateCommand();
		}
	}

}