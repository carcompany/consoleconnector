package com.carcompany.consoleconnector.command;

import com.carcompany.consoleconnector.CommandEnumeration;
import com.carcompany.consoleconnector.Dispatcher;

public class ListBookingServiceCommand extends Command {

    @Override
    public String getName() {
        return "Booking service";
    }

    @Override
    public void executeCommand() throws Exception {
        Dispatcher.getInstance().attachContext("Booking Service", CommandEnumeration.SHOW_BOOKINGS,
                CommandEnumeration.CREATE_BOOKING);
    }

}
