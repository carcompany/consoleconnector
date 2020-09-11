package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.personservice.structure.*;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:42
 */
public class CreateBookingView extends View {


	private Booking booking;

	public CreateBookingView(Booking booking) {

		this.booking = booking;

	}

	public void print() {

		System.out.println("–= BOOKING CREATED =–");
		System.out.println("FOR:");

		Person person = booking.getHead().getPerson();

		if (person instanceof NaturalPerson) {
			System.out.println("Firstname: " + ((NaturalPerson) person).getFirstname());
			System.out.println("Lastname: " + ((NaturalPerson) person).getLastname());
		} else {
			System.out.println("Company name: " + ((LegalPerson) person).getName());
		}
		System.out.println("PRICE:");
		System.out.println(booking.getBody().getResource().getPrice());

	}

	public void update() {


	}
}