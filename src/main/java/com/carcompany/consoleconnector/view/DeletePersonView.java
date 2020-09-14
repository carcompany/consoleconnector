package com.carcompany.consoleconnector.view;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:44
 */
public class DeletePersonView extends View {

	private int personId;

	public DeletePersonView(int personId) {
		super();
		this.personId = personId;
	}

	public void print() {
		System.out.printf("SUCCESS: Person with id %s got deleted", personId);
		System.out.println();
	}

	@Override
	public void update() {

	}
}