package com.carcompany.consoleconnector.command;

import com.carcompany.consoleconnector.CommandEnumeration;
import com.carcompany.consoleconnector.Dispatcher;

public class ListPersonServiceCommand extends Command {

    @Override
    public String getName() {
        return "Person service";
    }

    @Override
    public void executeCommand() throws Exception {
        Dispatcher.getInstance().attachContext("Person service", CommandEnumeration.CREATE_PERSON,
                CommandEnumeration.SHOW_PERSON, CommandEnumeration.DELETE_PERSON);
    }

}
