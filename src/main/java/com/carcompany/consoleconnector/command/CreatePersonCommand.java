package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.CreatePersonView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public class CreatePersonCommand extends Command {

	public void executeCommand() {

		String answer = ConsoleWrapper.getInstance().ask4Input("Create a natural Person (Y/n)?");
		Person person;

		if (answer.equals("n")) {
			person = CarReservationServiceObservable.getInstance()
					.createPerson(ConsoleWrapper.getInstance().ask4Input("What's the company's name"));
		} else {
			String firstname = ConsoleWrapper.getInstance().ask4Input("What's your firstname");
			String lastname = ConsoleWrapper.getInstance().ask4Input("What's your lastname");
			person = CarReservationServiceObservable.getInstance().createPerson(firstname, lastname);
		}

		View view = new CreatePersonView(person);
		view.print();
	}

	@Override
	public String getName() {
		return "Create a new person";
	}
}