/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package app.cancel;

import app.AppException;

/**
 * Form class for Cancel Reservation
 * 
 */
public class CancelReservationForm {

	private CancelReservationControl cancelReservationControl = new CancelReservationControl();

	private CancelReservationControl getCancelReservationControl() {
		return cancelReservationControl;
	}

	private String reservationNumber;

	public void cancelReservation() throws AppException {
		getCancelReservationControl().cancelReservation(reservationNumber);
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

}