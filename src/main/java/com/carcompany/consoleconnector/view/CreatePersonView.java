package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.personservice.structure.LegalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.NaturalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public class CreatePersonView extends View {

	private Person person;

	public CreatePersonView(Person person) {
		super();
		this.person = person;
	}

	public void print() {
		System.out.println("ID: " + this.person.getId());

		if (person instanceof NaturalPerson) {
			System.out.println("Firstname: " + ((NaturalPerson) person).getFirstname());
			System.out.println("Lastname: " + ((NaturalPerson) person).getLastname());
		} else {
			System.out.println("Company name: " + ((LegalPerson) person).getName());
		}
	}

	@Override
	public void update() {

	}
}