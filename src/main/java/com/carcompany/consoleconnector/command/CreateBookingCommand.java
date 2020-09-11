package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
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
	 */
	public void executeCommand(String[] arguments) {

		if(arguments.length == 3){

			Person person = (Person) clipboard.get(Person.class.getName() + ":" + arguments[0]);
			Resource resource = (Resource) clipboard.get(Resource.class.getName() + ":" + arguments[1]);

			Language language = Language.valueOf(arguments[2]);

			
			Booking booking = CarReservationServiceObservable.getInstance().createBooking(person, resource, language);

			View view = new CreateBookingView(booking);

			view.print();
			store(booking);

		}



	}
}