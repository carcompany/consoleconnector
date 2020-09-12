package com.carcompany.consoleconnector.command;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:41
 */
public abstract class Command {

	public abstract String getName();

	public abstract void executeCommand() throws Exception;

}