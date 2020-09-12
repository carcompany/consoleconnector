package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.ShowPersonView;
import com.carcompany.consoleconnector.view.View;

public class ShowPersonCommand extends Command {

    @Override
    public String getName() {
        return "Show a person";
    }

    @Override
    public void executeCommand() throws Exception {
        int personId = Integer.parseInt(ConsoleWrapper.getInstance().ask4Input("Person ID"));
        Person person = CarReservationServiceObservable.getInstance().showPerson(personId);

        View view = new ShowPersonView(person);
        view.print();
    }

}
