package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Room:Room ID, room number, type (single, double, suite), price, availability(boolean)

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="hotels")
public class Room {
	private static final String Double = null;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_number", length = 20, unique = true, nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING) 
    @Column(name = "type", nullable = false)
    private RoomType type; 

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "availability", nullable = false)
    private boolean availability;

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", type=" + type + ", price=" + price
				+ ", availability=" + availability + "]";
	}


    
    

	
	

}
