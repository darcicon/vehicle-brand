package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Vehicle;
import com.capg.entity.VehicleBrand;
import com.capg.exception.BrandNotFoundException;
import com.capg.repository.VehicleBrandRepository;
import com.capg.repository.VehicleRepository;
import com.capg.service.VehicleBrandImpl;

@RestController
@RequestMapping("/api/brand/")
public class VehicleBrandController {
	
	@Autowired
	private VehicleBrandImpl service;
	
	@Autowired
	VehicleBrandRepository vehicleBrandRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@PostMapping("/")
	public ResponseEntity<String> createBrand(@RequestBody VehicleBrand vehicleBrand) {
		
		service.createBrand(vehicleBrand);
		
		return new ResponseEntity<>("Added", HttpStatus.OK);
	}
	
	@PutMapping("/{brand_id}") 
	public ResponseEntity<String> updateBrand(@PathVariable int brand_id, @RequestBody VehicleBrand vehicleBrand) throws BrandNotFoundException {
		
		service.updateBrand(brand_id, vehicleBrand);
		
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/{brand_id}")
	public ResponseEntity<String> deleteBrand(@PathVariable int brand_id) {
		
		service.deleteBrand(brand_id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/{brand_id}")
	public VehicleBrand findById(@PathVariable int brand_id) {
		
		return vehicleBrandRepository.findById(brand_id).get();
	}
}

