package com.capg.service;

import com.capg.entity.VehicleBrand;

public interface IVehicleBrandService {
	
	public String createBrand(VehicleBrand vehicleBrand);
	
	public String updateBrand(int brand_id, VehicleBrand vehicleBrand);
	
	public String deleteBrand(int brand_id);


}
