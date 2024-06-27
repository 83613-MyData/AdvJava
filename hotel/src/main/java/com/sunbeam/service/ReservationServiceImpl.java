package com.sunbeam.service;

import java.time.LocalDate;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    public String cancelReservation(Long reservationId) {
        Reservation reservation = reservationDao.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        Room room = reservation.getRoom();
        
        //roomDao.setAv
        room.setAvailability(true);
        roomDao.save(room);
        reservationDao.delete(reservation);
        return "Reservation cancelled successfully";
    }

    @Override
    public Reservation createReservation(Guest guest, Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        Room room = roomDao.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not available"));
        if (!room.isAvailability()) {
            throw new RuntimeException("Room is not available");
        }

        room.setAvailability(false);
        roomDao.save(room);
        System.out.println(checkOutDate.lengthOfMonth());

        double totalPrice = room.getPrice() * (checkOutDate.toEpochDay() - checkInDate.toEpochDay());

        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setCheckInDate(checkInDate);
        reservation.setCheckOutDate(checkOutDate);
        reservation.setTotalPrice(totalPrice);

        return reservationDao.save(reservation);
    }
}
