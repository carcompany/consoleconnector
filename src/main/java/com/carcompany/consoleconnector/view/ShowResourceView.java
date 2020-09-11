package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:54
 */
public class ShowResourceView extends View {

	private Resource resource;

	public ShowResourceView(Resource resource) {

		this.resource = resource;

	}

	public void print() {

		System.out.println("PRICE: " + resource.getPrice());

	}

	public void update() {

	}
}