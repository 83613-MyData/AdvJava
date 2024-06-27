package com.sunbeam.dto;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDto {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resId;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guestId;
	
	@Future
	@NotBlank
	private LocalDate checkInDate;
	
	@Future
	@NotBlank
	private LocalDate checkOutDate;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomId;
	
	
	private double totalPrice;


}
