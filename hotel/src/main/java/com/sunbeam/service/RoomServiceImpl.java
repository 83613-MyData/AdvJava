package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.RoomDao;
import com.sunbeam.entities.Room;


@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomDao roomDao;

	@Override
	 public List<Room> getAvailableRooms(LocalDate checkInDate) {
        return roomDao.findAvailableRooms(checkInDate);
	}
//	public List<Room> getAvailableRooms() {
//		
//		return roomDao.findAll();
//	}

	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return roomDao.findAll();
	}

	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		try {
			Room savedRoom=roomDao.save(room);
			return savedRoom;
		} catch (RuntimeException e) {
			throw new RuntimeException("Room not added... try again"+e.getMessage());
		}
		
	}
	
	
}
