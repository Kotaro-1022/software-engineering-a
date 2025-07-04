/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package app.cancel;

import java.util.Date;

import app.AppException;
import app.ManagerFactory;
import domain.reservation.ReservationManager;
import domain.reservation.ReservationException;
import domain.room.RoomManager;
import domain.room.RoomException;

/**
 * Control class for Cancel Reservation
 * 
 */
public class CancelReservationControl {
	
	public void cancelReservation(String reservationNumber) throws AppException {
		try {
			//Get reservation details and consume it
			ReservationManager reservationManager = getReservationManager();
			Date stayingDate = reservationManager.consumeReservation(reservationNumber);
			
			//Update room availability
			RoomManager roomManager = getRoomManager();
			roomManager.updateRoomAvailableQty(stayingDate, 1);
		}
		catch (ReservationException e) {
			AppException exception = new AppException("Failed to cancel reservation", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
		catch (RoomException e) {
			AppException exception = new AppException("Failed to cancel reservation", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
	}

	private RoomManager getRoomManager() {
		return ManagerFactory.getInstance().getRoomManager();
	}

	private ReservationManager getReservationManager() {
		return ManagerFactory.getInstance().getReservationManager();
	}
}