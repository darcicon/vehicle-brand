package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.*;
import com.capg.repository.*;

@RestController
@RequestMapping("/api/booking")
public class VehicleBookingController {
	@Autowired
	private VehicleBookingRepository vehicleBookingRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@PostMapping("/book/vehicle{vehicleId}")
	public String bookVehicle(@RequestBody VehicleBooking vehicleBooking,@PathVariable int vehicleId) {
		Vehicle vehicle=vehicleRepository.findById(vehicleId).get();
		vehicle.setAvailable(false);
		vehicleBooking.setVehicle(vehicle);
		vehicleBookingRepository.save(vehicleBooking);
		return "Vehicle Booked";
	}
	@GetMapping("/details/")
	public List<VehicleBooking> bookingDetails() {
		return vehicleBookingRepository.findAll();
	}
	@GetMapping("/details/{id}")
	public VehicleBooking bookingDetails(@PathVariable int id) {
		return vehicleBookingRepository.findById(id).get();
	}
}
