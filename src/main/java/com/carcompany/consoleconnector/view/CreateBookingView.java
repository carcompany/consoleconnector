package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.personservice.structure.*;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceDecorator;

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
		System.out.println(String.format("⎡`````````` #%s ```````````⎤", booking.getId()));

		if (booking.getHead().getPerson() instanceof NaturalPerson) {
			System.out.println(
					String.format("| Firstname: %s ", ((NaturalPerson) booking.getHead().getPerson()).getFirstname()));
			System.out.println(
					String.format("| Lastname: %s ", ((NaturalPerson) booking.getHead().getPerson()).getLastname()));
		} else {
			System.out.println(
					String.format("| Company name: %s ", ((LegalPerson) booking.getHead().getPerson()).getName()));
		}

		System.out.println("⎪–––––––––––––––––––––––––⎪");

		Resource resource = booking.getBody().getResource();

		while (resource != null) {
			System.out.println(String.format("⎪ • %s", resource.getClass().getSimpleName()));

			if (resource instanceof ResourceDecorator) {
				resource = ((ResourceDecorator) resource).getResource();
			} else
				resource = null;
		}

		System.out.println("⎣_________________________⎦");
	}

	public void update() {

	}
}