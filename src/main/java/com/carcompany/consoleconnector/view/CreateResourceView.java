package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public class CreateResourceView extends View {

	private Resource resource;

	public CreateResourceView(Resource resource) {

		this.resource = resource;

	}

	public void print() {
		System.out.println("–= RESOURCE CREATED =–");
		System.out.println("PRICE: " + resource.getPrice());

	}

	public void update() {
		store(resource);

	}
}