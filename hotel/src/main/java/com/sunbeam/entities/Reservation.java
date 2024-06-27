package com.sunbeam.entities;
//Reservation:Reservation ID, guest id, check-in date, check-out date, 
//room ID, total price

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Registration_id")
	private Long resId;
	
	@ManyToOne
	@JoinColumn
	//(name="guest_id", nullable=false)
	private Guest guest;
	
	@Column(name="check_in_date", nullable = false)
	private LocalDate checkInDate;
	
	@Column(name="check_out_date", nullable = false)
	private LocalDate checkOutDate;
	
	
	@ManyToOne
	@JoinColumn
	//(name="room_id", nullable=false)
	private Room room;
	
	@Column(name="total_price")
	private double totalPrice;

	
	

}
