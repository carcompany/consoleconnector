package com.carcompany.consoleconnector.command;

import java.util.ArrayList;
import java.util.List;

import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.SelectResourceView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public class SelectResourceCommand extends Command {

	@Override
	public String getName() {
		return "Select a resource";
	}

	public void executeCommand() throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {

		List<ResourceEnumeration> list = new ArrayList<ResourceEnumeration>();

		for (String string : ConsoleWrapper.getInstance().ask4Input("Resource (comma seperated)").split(",")) {
			list.add(ResourceEnumeration.valueOf(string));

		}
		Resource resource = CarReservationServiceObservable.getInstance()
				.createResource(list.toArray(new ResourceEnumeration[list.size()]));

		View view = new SelectResourceView(resource);

		view.print();

	}
}