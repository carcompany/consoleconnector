package com.carcompany.consoleconnector.command;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:41
 */
public interface Command {

	/**
	 * 
	 * @param arguments
	 */
	public void executeCommand(String[] arguments);

}