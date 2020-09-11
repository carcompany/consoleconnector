package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public class PayBookingView extends View {

	private Booking paidBooking;

	public PayBookingView(Booking paidBooking) {

		this.paidBooking = paidBooking;


	}

	public void print() {

		System.out.println("–= BOOKING PAID =–");



	}

	public void update() {

	}
}