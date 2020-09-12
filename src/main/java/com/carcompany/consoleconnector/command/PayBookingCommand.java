package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.PayBookingView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public class PayBookingCommand extends Command {

	public void executeCommand() throws Exception {

		ConsoleWrapper consoleWrapper = ConsoleWrapper.getInstance();
		int bookingId = Integer.parseInt(consoleWrapper.ask4Input("Booking ID"));
		int accountId = Integer.parseInt(consoleWrapper.ask4Input("Account ID"));

		PaymentType paymentType = PaymentType
				.valueOf(consoleWrapper.ask4Input("Payment type (APPLE_PAY, GOOGLE_PAY, PAYPAL, BANK)"));

		String secret = ConsoleWrapper.getInstance().ask4Password("Please enter your password");

		Credential credential = CarReservationServiceObservable.getInstance()
				.createCredential(CredentialEnumeration.PASSWORD, secret);

		Booking paidBooking = CarReservationServiceObservable.getInstance().payBooking(bookingId, paymentType,
				accountId, credential);

		View view = new PayBookingView(paidBooking);
		view.print();
	}

	@Override
	public String getName() {
		return "Pay a booking";
	}
}