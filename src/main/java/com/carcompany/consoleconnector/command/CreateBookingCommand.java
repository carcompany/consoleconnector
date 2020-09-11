package com.carcompany.consoleconnector.command;

import java.util.ArrayList;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.view.CreateBookingView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:42
 */
public class CreateBookingCommand extends Command {

	public CreateBookingCommand() {
		super();
	}

	/**
	 * 
	 * @param arguments
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	public void executeCommand(String[] arguments) throws NumberFormatException, Exception {

		if (arguments.length == 3) {

			Person person = CarReservationServiceObservable.getInstance().showPerson(Integer.parseInt(arguments[0]));

			ArrayList<ResourceEnumeration> resourceEnumerations = new ArrayList<>();

			for (String resourceEnumerationString : arguments[1].split(",")) {
				resourceEnumerations.add(ResourceEnumeration.valueOf(resourceEnumerationString));
			}

			Resource resource = CarReservationServiceObservable.getInstance()
					.createResource(resourceEnumerations.toArray(ResourceEnumeration[]::new));

			Language language = Language.valueOf(arguments[2]);

			Booking booking = CarReservationServiceObservable.getInstance().createBooking(person, resource, language);

			View view = new CreateBookingView(booking);

			view.print();
		}
	}
}