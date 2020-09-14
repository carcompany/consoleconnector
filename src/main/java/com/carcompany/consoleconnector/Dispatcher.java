package com.carcompany.consoleconnector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import com.carcompany.consoleconnector.command.Command;
import com.carcompany.consoleconnector.command.CreateAccountCommand;
import com.carcompany.consoleconnector.command.CreateBookingCommand;
import com.carcompany.consoleconnector.command.CreatePersonCommand;
import com.carcompany.consoleconnector.command.DeletePersonCommand;
import com.carcompany.consoleconnector.command.ListBookingServiceCommand;
import com.carcompany.consoleconnector.command.ListPaymentServiceCommand;
import com.carcompany.consoleconnector.command.ListPersonServiceCommand;
import com.carcompany.consoleconnector.command.PayBookingCommand;
import com.carcompany.consoleconnector.command.SelectResourceCommand;
import com.carcompany.consoleconnector.command.ShowAccountCommand;
import com.carcompany.consoleconnector.command.ShowBookingsCommand;
import com.carcompany.consoleconnector.command.ShowPersonCommand;
import com.carcompany.consoleconnector.command.ShowStatisticsCommand;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:45
 */
public class Dispatcher {

	private static Dispatcher instance;
	private Context context;

	public static Dispatcher getInstance() {
		if (instance == null)
			instance = new Dispatcher();
		return instance;
	}

	public Dispatcher() {
		context = new Context(null, "Main Menu");
		context.setMenuItems(CommandEnumeration.LIST_PERSON_SERVICE, CommandEnumeration.LIST_BOOKING_SERVICE,
				CommandEnumeration.LIST_PAYMENT_SERVICE, CommandEnumeration.SHOW_STATISTICS,
				CommandEnumeration.SELECT_RESOURCE);
	}

	public Context getContext() {
		return this.context;
	}

	public Context attachContext(String name, CommandEnumeration... commandEnumerations) {
		this.context = new Context(this.context, name);
		this.context.setMenuItems(commandEnumerations);

		return this.context;
	}

	public void evaluateCommand() {

		Context context = this.context;
		ArrayList<String> names = new ArrayList<>();

		while (context != null) {
			names.add(context.getName());
			context = context.getContext();
		}

		Collections.reverse(names);

		System.out.printf("\n\n–––––––––––––– %s –––––––––––––––\n", String.join(" › ", names.toArray(String[]::new)));

		if (this.context.getContext() != null)
			System.out.println(String.format(" [0]	Go back"));

		for (Map.Entry<Integer, CommandEnumeration> entry : this.context.getMenuItems().entrySet()) {
			System.out.println(String.format(" [%s]	%s", entry.getKey(), resolveCommand(entry.getValue()).getName()));
		}

		System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");

		String dataInput = ConsoleWrapper.getInstance().ask4Input("Please select an item");

		try {
			Integer itemNumber = Integer.parseInt(dataInput);

			if (itemNumber == 0) {
				if (this.context.getContext() != null)
					this.context = this.context.getContext();
				else
					throw new RuntimeException("Cannot go one level up");
			} else {
				dispatchToCommand(this.context.getMenuItems().get(itemNumber));
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println("\033[0;31mError: Invalid option\033[0m");
		} catch (Exception e) {
			System.out.println("\033[0;31mError: " + e.getMessage() + "\033[0m");
		}
	}

	public Command resolveCommand(CommandEnumeration commandEnumeration) {
		Command command = null;

		switch (commandEnumeration) {
			case CREATE_BOOKING:
				command = new CreateBookingCommand();
				break;
			case CREATE_PERSON:
				command = new CreatePersonCommand();
				break;
			case SHOW_PERSON:
				command = new ShowPersonCommand();
				break;
			case SELECT_RESOURCE:
				command = new SelectResourceCommand();
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
			case CREATE_ACCOUNT:
				command = new CreateAccountCommand();
				break;
			case SHOW_ACCOUNT:
				command = new ShowAccountCommand();
				break;
			case LIST_PERSON_SERVICE:
				command = new ListPersonServiceCommand();
				break;
			case LIST_PAYMENT_SERVICE:
				command = new ListPaymentServiceCommand();
				break;
			case LIST_BOOKING_SERVICE:
				command = new ListBookingServiceCommand();
				break;
		}

		return command;
	}

	public void dispatchToCommand(CommandEnumeration commandEnumeration) throws Exception {
		Command command = resolveCommand(commandEnumeration);
		command.executeCommand();
	}
}