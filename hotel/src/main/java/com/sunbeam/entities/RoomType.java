package com.sunbeam.entities;

import lombok.Getter;
import lombok.Setter;


public enum RoomType {
	
	//SINGLE, DOUBLE, SUITE
    SINGLE("Single", 1500.0),
    DOUBLE("Double", 2500.0),
    SUITE("Suite", 5000.0);

	RoomType(String string, double d) {
		// TODO Auto-generated constructor stub
	}


}
