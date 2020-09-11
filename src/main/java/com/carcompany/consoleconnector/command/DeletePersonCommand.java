package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.behaviour.CarReservationService;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.exception.ArgumentsException;
import com.carcompany.consoleconnector.view.DeletePersonView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:44
 */
public class DeletePersonCommand extends Command {

	public DeletePersonCommand() {

	}

	/**
	 * 
	 * @param arguments
	 */
	public void executeCommand(String[] arguments) {

		if(arguments.length == 1){
			CarReservationServiceObservable.getInstance().deletePerson(Integer.parseInt(arguments[0]);
			View view = new DeletePersonView(arguments[0]);
			view.print();
		} else throw new ArgumentsException(
			String.format("One argument is required. Got %s arguments.", arguments.length));

	}
}