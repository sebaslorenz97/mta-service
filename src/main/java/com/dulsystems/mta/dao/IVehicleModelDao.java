package com.dulsystems.mta.dao;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;

public interface IVehicleModelDao {

	VehicleModelBean searchVehicleModelByModel(String vehicleModel);
	
	boolean executeSaveVehicleModel(RequestBean request, VehicleLineBean vlb);
	
	boolean executeUpdateVehicleModelByModel(RequestBean request, VehicleLineBean vlb);
	
	boolean removeVehicleModelByModel(String vehicleModel);
	
}
