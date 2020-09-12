package com.carcompany.consoleconnector.command;

import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.view.ShowBookingsView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:53
 */
public class ShowBookingsCommand extends Command {

	@Override
	public String getName() {
		return "List all bookings";
	}

	@Override
	public void executeCommand() throws Exception {
		View view = new ShowBookingsView(CarReservationServiceObservable.getInstance().showBookings());
		view.print();
	}
}