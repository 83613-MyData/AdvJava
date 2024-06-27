package com.sunbeam.controller;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sunbeam.entities.Room;
import com.sunbeam.service.RoomService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@Getter
@Setter
@ToString


@RestController
@RequestMapping("/rooms")

public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public List<Room> listAllRoom() {
		System.out.println("in room");
		return roomService.getAllRooms();
	}
	
	
	 @GetMapping("/available/{checkInDate}")
	    public List<Room> getAvailableRooms(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate) {
	        return roomService.getAvailableRooms(checkInDate);
	    }
	 
	 @PostMapping
	    public ResponseEntity<String> addRoom(@RequestBody Room room) {
	        Room addedRoom = roomService.addRoom(room);
	        return ResponseEntity.ok("Room added successfully with ID: " + addedRoom.getRoomId());
	    }
	 

	 
	

}
