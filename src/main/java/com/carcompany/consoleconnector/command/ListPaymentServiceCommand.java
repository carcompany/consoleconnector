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
        Dispatcher.getInstance().attachContext("Payment Service", CommandEnumeration.CREATE_ACCOUNT,
                CommandEnumeration.SHOW_ACCOUNT, CommandEnumeration.PAY_BOOKING);
    }
}
