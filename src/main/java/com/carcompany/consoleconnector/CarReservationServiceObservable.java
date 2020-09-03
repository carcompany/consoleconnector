package com.carcompany.consoleconnector;

import com.carcompany.carreservationservice.behaviour.CarReservationService;
import com.carcompany.carreservationservice.behaviour.CarReservationServiceImplementation;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:40
 */
public class CarReservationServiceObservable extends Observable implements CarReservationService {

	private CarReservationService carReservationService;

	public CarReservationServiceObservable() {
		carReservationService = new CarReservationServiceImplementation();
	}

	/**
	 * 
	 * @param parameters
	 */
	public Person createPerson(String... parameters) {
		return carReservationService.createPerson(parameters);
	}

	/**
	 * 
	 * @param personId
	 */
	public void deletePerson(int personId) {
		carReservationService.deletePerson(personId);
	}

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public Resource createResource(ResourceEnumeration... resourceEnumeration) {
		return carReservationService.createResource(resourceEnumeration);
	}

	/**
	 * 
	 * @param personId
	 */
	public void authenticatePerson(int personId) {
		
	}

	public void showStatistics() {

	}

	/**
	 * 
	 * @param bookingId
	 */
	public void payBooking(int bookingId) {

	}

	public void showBookings() {
		
	}

	/**
	 * 
	 * @param personId
	 * @param resourceId
	 * @param language
	 */
	public Booking createBooking(Person person, Resource resource, Language language) {
		return carReservationService.createBooking(person, resource, language);
	}
}