package com.sunbeam.entities;
//Guest :Guest ID  first name ,last name , dob

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="guests")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="guest_id")
	private Long guestId;
	
	@Column(name="first_name", nullable = false, length=25)
	private String firstName;
	
	@Column(name="last_name", nullable = false, length=25)
	private String lastName;
	
	
	private LocalDate dob;
	

}
