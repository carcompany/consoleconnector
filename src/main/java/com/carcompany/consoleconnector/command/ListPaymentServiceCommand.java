package com.carcompany.consoleconnector.command;

import com.carcompany.consoleconnector.CommandEnumeration;
import com.carcompany.consoleconnector.Dispatcher;

public class ListPaymentServiceCommand extends Command {
    @Override
    public String getName() {
        return "Payment service";
    }

    @Override
    public void executeCommand() throws Exception {
        Dispatcher.getInstance().attachContext("Payment Service", CommandEnumeration.PAY_BOOKING,
                CommandEnumeration.CREATE_ACCOUNT);
    }
}
