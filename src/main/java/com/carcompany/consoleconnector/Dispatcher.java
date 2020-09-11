package com.carcompany.consoleconnector;

import java.util.ArrayList;
import java.util.Arrays;

import com.carcompany.consoleconnector.command.Command;
import com.carcompany.consoleconnector.command.CreateAccountCommand;
import com.carcompany.consoleconnector.command.CreateBookingCommand;
import com.carcompany.consoleconnector.command.CreatePersonCommand;
import com.carcompany.consoleconnector.command.CreateResourceCommand;
import com.carcompany.consoleconnector.command.DeletePersonCommand;
import com.carcompany.consoleconnector.command.ListClipboardCommand;
import com.carcompany.consoleconnector.command.PayBookingCommand;
import com.carcompany.consoleconnector.command.ShowBookingsCommand;
import com.carcompany.consoleconnector.command.ShowStatisticsCommand;
import com.carcompany.consoleconnector.exception.ArgumentsException;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:45
 */
public class Dispatcher {

	public void evaluateCommand() {
		String dataInput = ConsoleWrapper.getInstance().getInput();
		ArrayList<String> arguments = new ArrayList<String>(Arrays.asList(dataInput.split(" ")));

		if (arguments.size() > 0) {
			try {
				String enumerationString = arguments.remove(0);
				dispatchToCommand(CommandEnumeration.valueOf(enumerationString), arguments.toArray(String[]::new));
			} catch (IllegalArgumentException e) {
				System.out.println("Error: Command does not exist");
			}
		}
	}

	/**
	 * 
	 * @param commandEnumeration
	 */
	public void dispatchToCommand(CommandEnumeration commandEnumeration, String[] arguments) {
		Command command = null;

		switch (commandEnumeration) {
			case CREATE_BOOKING:
				command = new CreateBookingCommand();
				break;
			case CREATE_PERSON:
				command = new CreatePersonCommand();
				break;
			case CREATE_RESOURCE:
				command = new CreateResourceCommand();
				break;
			case DELETE_PERSON:
				command = new DeletePersonCommand();
				break;
			case PAY_BOOKING:
				command = new PayBookingCommand();
				break;
			case SHOW_BOOKINGS:
				command = new ShowBookingsCommand();
				break;
			case SHOW_STATISTICS:
				command = new ShowStatisticsCommand();
				break;
			case LIST_CLIPBOARD:
				command = new ListClipboardCommand();
				break;
			case CREATE_ACCOUNT:
				command = new CreateAccountCommand();
				break;
			default:
				break;
		}

		try {
			command.executeCommand(arguments);
		} catch (ArgumentsException err) {
			System.out.println("Arguments error: " + err.getMessage());
		} catch (Exception err){
			System.out.println("Exception error: " + err.getMessage());
		}
	}
}