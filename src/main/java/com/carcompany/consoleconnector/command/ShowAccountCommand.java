package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.ShowAccountView;
import com.carcompany.consoleconnector.view.View;

public class ShowAccountCommand extends Command {

    @Override
    public String getName() {
        return "Show account information";
    }

    @Override
    public void executeCommand() throws Exception {
        int accountId = Integer.parseInt(ConsoleWrapper.getInstance().ask4Input("Account ID"));
        Account account = CarReservationServiceObservable.getInstance().showAccount(accountId);
        View view = new ShowAccountView(account);
        view.print();
    }

}
