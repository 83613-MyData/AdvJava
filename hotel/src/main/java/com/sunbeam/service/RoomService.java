package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sunbeam.entities.Room;


public interface RoomService {

	List<Room> getAllRooms();

	List<Room> getAvailableRooms(LocalDate checkInDate);

	Room addRoom(Room room);

	

}
