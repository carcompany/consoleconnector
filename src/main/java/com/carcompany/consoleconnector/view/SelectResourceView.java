package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceDecorator;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public class SelectResourceView extends View {

	private Resource resource;

	public SelectResourceView(Resource resource) {
		super();
		this.resource = resource;
	}

	public void print() {
		System.out.println("–––– Resource ––––");
		Resource resource = this.resource;
		Double totalPrice = 0.0;

		while (resource != null) {
			System.out.println(" • " + resource.getClass().getSimpleName());
			totalPrice += resource.getPrice();

			if (resource instanceof ResourceDecorator) {
				resource = ((ResourceDecorator) resource).getResource();
			} else
				resource = null;
		}

		System.out.println("Total price: " + totalPrice);

	}

	@Override
	public void update() {

	}
}