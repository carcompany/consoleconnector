package com.carcompany.consoleconnector.view;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.Statistic;

/**
 * @author Benjamin Esdor
 * @version 1.0
 * @created 28-Aug-2020 17:10:54
 */
public class ShowStatisticsView extends View {

	private Statistic statistic;

	public ShowStatisticsView(Statistic statistic) {
		this.statistic = statistic;

	}

	public void print() {

		System.out.println("–= STATISTIC =–");
		System.out.println("SUM OF PAYMENTS: " + statistic.getPaymentSum());
		System.out.println("SUM OF BOOKINGS: " + statistic.getBookingSum());

	}

	public void update() {

	}
}