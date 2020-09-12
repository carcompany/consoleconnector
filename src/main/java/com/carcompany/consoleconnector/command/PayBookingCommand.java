package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.AppleAccount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.BankAccount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.GoogleAccount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.PayPalAccount;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.exception.ArgumentsException;
import com.carcompany.consoleconnector.view.PayBookingView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public class PayBookingCommand extends Command {

	public PayBookingCommand() {

	}

	/**
	 * 
	 * @param arguments
	 * @throws Exception
	 */
	public void executeCommand(String[] arguments) throws Exception {

		if (arguments.length == 3) {

			Booking booking = CarReservationServiceObservable.getInstance().showBooking(Integer.parseInt(arguments[0]));
			PaymentType paymentType = PaymentType.valueOf(arguments[1]);
			Account account;

			switch (paymentType) {
				case APPLE_PAY:
					account = (AppleAccount) clipboard.get(AppleAccount.class.getName() + ":" + arguments[2]);
					break;
				case BANK:
					account = (BankAccount) clipboard.get(BankAccount.class.getName() + ":" + arguments[2]);
					break;
				case GOOGLE_PAY:
					account = (GoogleAccount) clipboard.get(GoogleAccount.class.getName() + ":" + arguments[2]);
					break;
				case PAYPAL:
					account = (PayPalAccount) clipboard.get(PayPalAccount.class.getName() + ":" + arguments[2]);
					break;
				default:
					throw new Exception("PaymentType is not supported!");
			}

			String secret = ConsoleWrapper.getInstance().ask4Password("Please enter your password");

			Credential credential = CarReservationServiceObservable.getInstance()
					.createCredential(CredentialEnumeration.PASSWORD, secret);

			if (account != null) {

				Booking paidBooking = CarReservationServiceObservable.getInstance().payBooking(booking, paymentType,
						account, credential);

				if (paidBooking != null) {
					View view = new PayBookingView(paidBooking);
					view.print();
				}

			}

		} else {
			throw new ArgumentsException(
					String.format("Three arguments are required. Got %s arguments.", arguments.length));

		}

	}
}