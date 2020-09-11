package com.carcompany.consoleconnector.command;

import com.carcompany.consoleconnector.Clipboard;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:41
 */
public abstract class Command {

	protected Clipboard clipboard;


	Command(){
		this.clipboard = Clipboard.getInstance();
	}

	/**
	 * 
	 * @param arguments
	 */
	public abstract void executeCommand(String[] arguments) throws Exception;

}