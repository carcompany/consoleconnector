package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.ConsoleWrapper;
import com.carcompany.consoleconnector.view.ShowStatisticsView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:54
 */
public class ShowStatisticsCommand extends Command {

	@Override
	public String getName() {
		return "Show statistics for current month";
	}

	@Override
	public void executeCommand() throws Exception {

		Language language = Language.valueOf(ConsoleWrapper.getInstance().ask4Input("Language (GERMAN, ENGLISH)"));
		ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration = ExternalPaymentServiceEnumeration.valueOf(
				ConsoleWrapper.getInstance().ask4Input("Payment Service (APPLE_PAY, GOOGLE_PAY, BANK, PAYPAL)"));

		View view = new ShowStatisticsView(CarReservationServiceObservable.getInstance().showStatistics(language,
				externalPaymentServiceEnumeration));
		view.print();
	}
}