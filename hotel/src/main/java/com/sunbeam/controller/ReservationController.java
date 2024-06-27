package com.sunbeam.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.service.ReservationService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@DeleteMapping("/{reservationId}")
    public String cancelReservation(@PathVariable Long reservationId) {
        reservationService.cancelReservation(reservationId);
	        return reservationId+"this reservation is deleted successfully"; 
	

}
	
	@PostMapping("/doReservation")
    public ResponseEntity<Reservation> createReservation(
            @RequestParam Guest guest,
            @RequestParam Long roomId,
            @RequestParam  LocalDate checkInDate,
            @RequestParam  LocalDate checkOutDate) {

        try {
            Reservation reservation = reservationService.createReservation(guest, roomId, checkInDate, checkOutDate);
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}