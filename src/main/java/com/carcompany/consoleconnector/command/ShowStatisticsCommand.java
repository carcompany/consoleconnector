package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.Statistic;
import com.carcompany.consoleconnector.CarReservationServiceObservable;
import com.carcompany.consoleconnector.exception.ArgumentsException;
import com.carcompany.consoleconnector.view.ShowStatisticsView;
import com.carcompany.consoleconnector.view.View;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:54
 */
public class ShowStatisticsCommand extends Command {

	public ShowStatisticsCommand() {

	}

	/**
	 * 
	 * @param arguments
	 */
	public void executeCommand(String[] arguments) {

		if(arguments.length > 0 && arguments.length < 3){
			Statistic statistic = CarReservationServiceObservable.getInstance().showStatistics(Language.valueOf(arguments[0]), ExternalPaymentServiceEnumeration.valueOf(arguments[1]));
			
			View view = new ShowStatisticsView(statistic);
			view.print();

		} else {
			throw new ArgumentsException(
					String.format("Two arguments are required. Got %s arguments.", arguments.length));
		}

	}
}