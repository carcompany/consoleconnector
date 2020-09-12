package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.exception.ArgumentsException;
import com.carcompany.consoleconnector.view.CreateAccountView;
import com.carcompany.consoleconnector.view.View;

public class CreateAccountCommand extends Command {

	@Override
	public void executeCommand(String[] arguments) throws Exception {

		if (arguments.length == 2) {

			Account account;
			ConsoleWrapper console = ConsoleWrapper.getInstance();

			String credentialType = console.ask4Input("Please specify credential type");

			switch (CredentialEnumeration.valueOf(credentialType)) {
				case PASSWORD:
					String password;
					String password2;
					do {

						password = console.ask4Password("Please enter a password for your new account");
						password2 = console.ask4Password("Please repeat the entered password");

						if (!password.equals(password2)) {
							System.out.println("Password does not match. Please try again");
						}
					} while (!password.equals(password2));

					Person person = CarReservationServiceObservable.getInstance()
							.showPerson(Integer.parseInt(arguments[0]));

					account = CarReservationServiceObservable.getInstance().createAccount(person,
							CredentialEnumeration.PASSWORD, password, PaymentType.valueOf(arguments[1]));

					View view = new CreateAccountView(account);

					view.print();
					store(account);

					break;

				default:
					System.out.println("Method not supported yet.");
					break;
			}

		} else {
			throw new ArgumentsException(
					String.format("Two arguments are required. Got %s arguments.", arguments.length));
		}

	}

}
