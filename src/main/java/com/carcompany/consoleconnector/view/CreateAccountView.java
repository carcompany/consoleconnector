package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.PersonSubject;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.personservice.structure.*;

public class CreateAccountView extends View {

    private Account account;

    public CreateAccountView(Account account) {
        super();
        this.account = account;
    }

    @Override
    public void print() {

        Person person = ((PersonSubject) account.getSubject()).getPerson();

        System.out.println("Account ID:   " + account.getId());
        System.out.println("Account type: " + account.getClass().getSimpleName());

        if (person instanceof NaturalPerson) {
            System.out.println("Firstname:  " + ((NaturalPerson) person).getFirstname());
            System.out.println("Lastname:   " + ((NaturalPerson) person).getLastname());
        } else {
            System.out.println("Company name: " + ((LegalPerson) person).getName());
        }

        System.out.println("Balance:      " + account.getBalance().getAmount());
    }

    @Override
    public void update() {

    }
}
