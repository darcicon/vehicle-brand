package com.capg.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	Vehicle findByVehicleTypeAndVehicleName(String vehicleType,String vehicleName);
	Vehicle findByVehicleTypeAndVehicleNameAndVehicleColor(String vehicleType,String VehicleName,String vehicleColor);
}
