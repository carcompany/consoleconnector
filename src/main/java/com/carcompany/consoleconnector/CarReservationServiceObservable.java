package com.carcompany.consoleconnector;

import java.util.Map;

import javax.security.sasl.AuthenticationException;

import com.carcompany.carreservationservice.behaviour.CarReservationService;
import com.carcompany.carreservationservice.behaviour.CarReservationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.exception.UnsupportedPaymentTypeException;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.personservice.structure.exception.TooFewOrManyParametersForPersonCreationException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.Statistic;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:40
 */
public class CarReservationServiceObservable extends Observable implements CarReservationService {

	private static CarReservationServiceObservable carReservationServiceObservable;

	public static CarReservationServiceObservable getInstance() {
		if (carReservationServiceObservable == null) {
			carReservationServiceObservable = new CarReservationServiceObservable();
		}

		return carReservationServiceObservable;
	}

	private CarReservationService carReservationService;

	public CarReservationServiceObservable() {
		carReservationService = new CarReservationServiceImplementation();
	}

	public Person createPerson(String... parameters) {
		notifySubscribers();
		return carReservationService.createPerson(parameters);
	}

	public Resource createResource(ResourceEnumeration... resourceEnumeration)
			throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		notifySubscribers();
		return carReservationService.createResource(resourceEnumeration);
	}

	public Booking createBooking(Person person, Resource resource, Language language) {
		notifySubscribers();
		return carReservationService.createBooking(person, resource, language);
	}

	@Override
	public Account createAccount(Person person, CredentialEnumeration credentialEnumeration, Object secret,
			PaymentType paymentType) throws TooFewOrManyParametersForPersonCreationException {
		notifySubscribers();
		return carReservationService.createAccount(person, credentialEnumeration, secret, paymentType);
	}

	@Override
	public Credential createCredential(CredentialEnumeration credentialEnumeration, Object secret) {
		notifySubscribers();
		return carReservationService.createCredential(credentialEnumeration, secret);
	}

	@Override
	public Booking payBooking(Booking booking, PaymentType paymentType, Account account, Credential credential)
			throws AuthenticationException, UnsupportedPaymentTypeException {
		notifySubscribers();
		return carReservationService.payBooking(booking, paymentType, account, credential);
	}

	@Override
	public Statistic showStatistics(Language language,
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration) {
		return carReservationService.showStatistics(language, externalPaymentServiceEnumeration);
	}

	@Override
	public void deletePerson(int id) throws Exception {
		notifySubscribers();
		carReservationService.deletePerson(id);
	}

	@Override
	public Booking showBooking(int id) {
		return carReservationService.showBooking(id);
	}

	@Override
	public Map<Integer, Booking> showBookings() {
		return carReservationService.showBookings();
	}

	@Override
	public Person showPerson(int id) throws Exception {
		return carReservationService.showPerson(id);
	}
}