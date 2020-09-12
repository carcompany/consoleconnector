package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public class PayBookingView extends View {

	private Booking booking;

	public PayBookingView(Booking booking) {
		this.booking = booking;
	}

	public void print() {
		System.out.println("Executing payment...");

		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("SUCCESS: Booking #%s got paid\n", booking.getId());
	}

	public void update() {

	}
}