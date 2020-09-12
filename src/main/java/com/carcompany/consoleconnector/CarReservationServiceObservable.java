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
import com.carcompany.carreservationservice.structure.paymentservice.structure.exception.PaymentExecutionException;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

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

	public Booking createBooking(int personId, Resource resource, Language language) throws Exception {
		notifySubscribers();
		return carReservationService.createBooking(personId, resource, language);
	}

	@Override
	public Account createAccount(int personId, CredentialEnumeration credentialEnumeration, Object secret,
			PaymentType paymentType) throws Exception {
		notifySubscribers();
		return carReservationService.createAccount(personId, credentialEnumeration, secret, paymentType);
	}

	@Override
	public Credential createCredential(CredentialEnumeration credentialEnumeration, Object secret) {
		notifySubscribers();
		return carReservationService.createCredential(credentialEnumeration, secret);
	}

	@Override
	public Booking payBooking(int bookingId, PaymentType paymentType, int accountId, Credential credential)
			throws AuthenticationException, PaymentExecutionException {
		notifySubscribers();
		return carReservationService.payBooking(bookingId, paymentType, accountId, credential);
	}

	@Override
	public ExternalPaymentStatistic showStatistics(Language language,
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration) {
		return carReservationService.showStatistics(language, externalPaymentServiceEnumeration);
	}

	@Override
	public void deletePerson(int personId) throws Exception {
		notifySubscribers();
		carReservationService.deletePerson(personId);
	}

	@Override
	public Booking showBooking(int bookingId) {
		return carReservationService.showBooking(bookingId);
	}

	@Override
	public Map<Integer, Booking> showBookings() {
		return carReservationService.showBookings();
	}

	@Override
	public Person showPerson(int personId) throws Exception {
		return carReservationService.showPerson(personId);
	}

	@Override
	public Account showAccount(int accountId) {
		return carReservationService.showAccount(accountId);
	}
}