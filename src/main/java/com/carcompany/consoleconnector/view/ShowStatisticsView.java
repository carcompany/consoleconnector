package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:54
 */
public class ShowStatisticsView extends View {

	private ExternalPaymentStatistic statistic;

	public ShowStatisticsView(ExternalPaymentStatistic statistic) {
		this.statistic = statistic;
	}

	public void print() {
		System.out.println("Revenue of payments:  " + statistic.getPaymentSum());
		System.out.println("Amount of bookings:   " + statistic.getBookingSum());
	}

	public void update() {

	}
}