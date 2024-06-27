package com.sunbeam.dao;

import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Room;

public interface RoomDao extends JpaRepository<Room, Long> {
	@Query("SELECT r FROM Room r WHERE r.availability = true AND r.roomId NOT IN (SELECT res.room.roomId FROM Reservation res WHERE :checkInDate BETWEEN res.checkInDate AND res.checkOutDate)")
    List<Room> findAvailableRooms(@Param("checkInDate") LocalDate checkInDate);
	

}
