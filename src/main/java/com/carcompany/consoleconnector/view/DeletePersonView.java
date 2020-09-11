package com.carcompany.consoleconnector.view;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:44
 */
public class DeletePersonView extends View {

	private String identifier;

	public DeletePersonView(String id) {

		this.identifier = id;

		


	}

	public void print() {
		System.out.println("–= PERSON DELETED =–");
		System.out.println("ID: " + this.identifier);
	}

	public void update() {

	}
}