package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.personservice.structure.LegalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.NaturalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

public class ShowPersonView extends View {

    private Person person;

    public ShowPersonView(Person person) {
        super();
        this.person = person;
    }

    @Override
    public void print() {
        System.out.println("ID: " + this.person.getId());

        if (person instanceof NaturalPerson) {
            System.out.println("Firstname: " + ((NaturalPerson) person).getFirstname());
            System.out.println("Lastname: " + ((NaturalPerson) person).getLastname());
        } else {
            System.out.println("Company name: " + ((LegalPerson) person).getName());
        }
    }

    @Override
    public void update() {

    }
}
