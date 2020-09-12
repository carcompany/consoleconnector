package com.carcompany.consoleconnector.command;

import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.DeletePersonView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:44
 */
public class DeletePersonCommand extends Command {

	public void executeCommand() throws NumberFormatException, Exception {
		int personId = Integer.parseInt(ConsoleWrapper.getInstance().ask4Input("Person ID"));

		CarReservationServiceObservable.getInstance().deletePerson(personId);
		View view = new DeletePersonView(personId);
		view.print();
	}

	@Override
	public String getName() {
		return "Delete a person";
	}
}