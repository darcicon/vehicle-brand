package com.capg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class VehicleBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String bookingStartDate;
	private String bookingEndDate;
	
	@OneToOne
	@JoinColumn(name = "vehicleId",referencedColumnName = "vehicleId")
	private Vehicle vehicle;
}
