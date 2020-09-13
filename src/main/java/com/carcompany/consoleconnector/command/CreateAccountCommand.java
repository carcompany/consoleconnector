package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.CreateAccountView;
import com.carcompany.consoleconnector.view.View;

public class CreateAccountCommand extends Command {

	public String getName() {
		return "Create an account";
	}

	@Override
	public void executeCommand() throws Exception {

		Account account;
		ConsoleWrapper console = ConsoleWrapper.getInstance();

		int personId = Integer.parseInt(console.ask4Input("Person ID"));

		PaymentType paymentType = PaymentType
				.valueOf(console.ask4Input("Payment type (APPLE_PAY, GOOGLE_PAY, BANK, PAYPAL)"));
		String credentialType = console.ask4Input("Credential type (e.g. PASSWORD)");

		switch (CredentialEnumeration.valueOf(credentialType)) {
			case PASSWORD:

				String password;
				String password2;

				do {

					password = console.ask4Password("Please enter a password for your new account");
					password2 = console.ask4Password("Please repeat the entered password");

					if (!password.equals(password2)) {
						System.out.println("Passwords did not match. Please try again");
					}
				} while (!password.equals(password2));

				account = CarReservationServiceObservable.getInstance().createAccount(personId,
						CredentialEnumeration.PASSWORD, password, paymentType);

				View view = new CreateAccountView(account);
				view.print();

				break;
			default:
				throw new Error("Method is not supported yet.");
		}

	}

}
