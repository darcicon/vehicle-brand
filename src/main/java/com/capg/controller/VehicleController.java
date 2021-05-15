package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Vehicle;
import com.capg.entity.VehicleBrand;
import com.capg.repository.VehicleBrandRepository;
import com.capg.repository.VehicleRepository;
import com.capg.service.VehicleBrandImpl;

@RestController
@RequestMapping("/api/vehicle/")
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	VehicleBrandRepository vehicleBrandRepository;
	
	@PostMapping("/add")
	public String addVehicle(@RequestBody Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		return "Vehicle Added";
	}
	
	@GetMapping("/search/type/{vehicleType}/name/{vehicleName}")
	public Vehicle searchVehicle(@PathVariable String vehicleType,@PathVariable String vehicleName) {
		Vehicle vehicle=vehicleRepository.findByVehicleTypeAndVehicleName(vehicleType, vehicleName);
		return vehicle;
	}
	@GetMapping("/search/type/{vehicleType}/name/{vehicleName}/color/{vehicleColor}")
	public Vehicle seacrhVehicleV1(@PathVariable String vehicleType,
			@PathVariable String vehicleName,@PathVariable String vehicleColor) {
		Vehicle vehicle=vehicleRepository.findByVehicleTypeAndVehicleNameAndVehicleColor(
				vehicleType, vehicleName, vehicleColor);
		return vehicle;
	}
	@GetMapping("/search/all")
	public List<Vehicle> searchAllVehicle() {
		return vehicleRepository.findAll();
	}
	
	@PutMapping("brand/{brand_id}/vehicle/{vehicleId}")
	public String assignBrandToVehicle(@PathVariable int brand_id, @PathVariable int vehicleId) {
		
		VehicleBrand vehicleBrand =  vehicleBrandRepository.findById(brand_id).get();
		Vehicle vehicle =  vehicleRepository.findById(vehicleId).get();
		
		vehicle.setVehicleBrand(vehicleBrand);
		
		// updated.
		vehicleRepository.save(vehicle);
		return "Brand Added";
	}
}
