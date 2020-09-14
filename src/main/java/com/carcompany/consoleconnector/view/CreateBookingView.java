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
		super();
		this.booking = booking;
	}

	public void print() {
		System.out.println(String.format("⎡````````` ID: %s `````````⎤", booking.getId()));

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

		Double totalPrice = 0.0;

		while (resource != null) {
			System.out.println(String.format("⎪ • %s", resource.getClass().getSimpleName()));
			totalPrice += resource.getPrice();

			if (resource instanceof ResourceDecorator) {
				resource = ((ResourceDecorator) resource).getResource();
			} else
				resource = null;
		}

		System.out.printf("⎪ Total price: %s\n", totalPrice);

		System.out.println("⎪–––––––––––––––––––––––––⎪");

		System.out.println(String.format("| Paid status: %s ", booking.getFooter().getPayment() != null ? "✅" : "❌"));

		System.out.println("⎣_________________________⎦");
	}

	@Override
	public void update() {

	}
}