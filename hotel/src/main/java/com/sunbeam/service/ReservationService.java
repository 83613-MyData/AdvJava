package com.sunbeam.service;

import java.time.LocalDate;

import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;

public interface ReservationService {
	public String cancelReservation(Long reservationId);
	Reservation createReservation(Guest guestId, Long roomId, LocalDate checkInDate, LocalDate checkOutDate);

}
