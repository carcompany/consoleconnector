package com.carcompany.consoleconnector.command;

import java.util.ArrayList;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.CreateBookingView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:42
 */
public class CreateBookingCommand extends Command {

	@Override
	public String getName() {
		return "Create a new booking";
	}

	/**
	 * 
	 * @param arguments
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	public void executeCommand() throws NumberFormatException, Exception {

		ConsoleWrapper console = ConsoleWrapper.getInstance();

		int personId = Integer.parseInt(console.ask4Input("Person ID"));

		ArrayList<ResourceEnumeration> resourceEnumerations = new ArrayList<>();

		for (String resourceEnumerationString : console.ask4Input("Select a resource combination (comma seperated)")
				.split(",")) {
			resourceEnumerations.add(ResourceEnumeration.valueOf(resourceEnumerationString));
		}

		Resource resource = CarReservationServiceObservable.getInstance()
				.createResource(resourceEnumerations.toArray(ResourceEnumeration[]::new));

		Language language = Language.valueOf(console.ask4Input("Language (GERMAN, ENGLISH)"));

		Booking booking = CarReservationServiceObservable.getInstance().createBooking(personId, resource, language);

		View view = new CreateBookingView(booking);

		view.print();

	}
}