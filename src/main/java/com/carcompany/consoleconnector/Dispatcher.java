package com.carcompany.consoleconnector;

import java.util.Scanner;

import com.carcompany.consoleconnector.command.AuthenticatePersonCommand;
import com.carcompany.consoleconnector.command.Command;
import com.carcompany.consoleconnector.command.CreateBookingCommand;
import com.carcompany.consoleconnector.command.CreatePersonCommand;
import com.carcompany.consoleconnector.command.CreateResourceCommand;
import com.carcompany.consoleconnector.command.DeletePersonCommand;
import com.carcompany.consoleconnector.command.DeleteResourceCommand;
import com.carcompany.consoleconnector.command.PayBookingCommand;
import com.carcompany.consoleconnector.command.ShowBookingsCommand;
import com.carcompany.consoleconnector.command.ShowResourceCommand;
import com.carcompany.consoleconnector.command.ShowStatisticsCommand;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:45
 */
public class Dispatcher {

	public void evaluateCommand() {
		Scanner scanner = new Scanner(System.in);
		String dataInput = scanner.nextLine();
		String[] arguments = dataInput.split(" ");

		if(arguments.length > 0) {
			try {
				dispatchToCommand(CommandEnumeration.valueOf(arguments[0]), arguments);
			} catch(IllegalArgumentException e) {
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

		switch(commandEnumeration) {
			case CREATE_BOOKING:
				command = new CreateBookingCommand();
				break;
			case AUTHENTICATE_PERSON:
				command = new AuthenticatePersonCommand();
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
			case DELETE_RESOURCE:
				command = new DeleteResourceCommand();
				break;
			case PAY_BOOKING:
				command = new PayBookingCommand();
				break;
			case SHOW_BOOKINGS:
				command = new ShowBookingsCommand();
				break;
			case SHOW_RESOURCE:
				command = new ShowResourceCommand();
				break;
			case SHOW_STATISTICS:
				command = new ShowStatisticsCommand();
				break;
		}

		command.excuteCommand(arguments);
	}
}