package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.exception.ArgumentsException;
import com.carcompany.consoleconnector.view.CreatePersonView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public class CreatePersonCommand extends Command {


	public void executeCommand(String[] arguments) {
		if (arguments.length > 0 && arguments.length <= 2) {
			Person person = CarReservationServiceObservable.getInstance().createPerson(arguments);
			

			View view = new CreatePersonView(person);
			view.print();
			store(person);
		} else
			throw new ArgumentsException(
					String.format("Two or one argument(s) are required. Got %s arguments.", arguments.length));
	}
}