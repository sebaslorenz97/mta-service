package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IVehicleCatalogsService {
	
	//SERVICES FOR VEHICLE LINES
	ResponseBean searchVehicleLineByLine(String vehicleLine);
	ResponseBean executeSaveVehicleLine(RequestBean request);
	ResponseBean executeUpdateVehicleLineByLine(RequestBean request);
	ResponseBean removeVehicleLineByLine(String vehicleLine);
	
	//SERVICES FOR VEHICLE MODELS
	ResponseBean searchVehicleModelByModel(String vehicleModel);
	ResponseBean executeSaveVehicleModel(RequestBean request);
	ResponseBean executeUpdateVehicleModelByModel(RequestBean request);
	ResponseBean removeVehicleModelByModel(String vehicleModel);
	
	//SERVICES FOR VEHICLE YEARS
	ResponseBean searchVehicleYearByYear(Integer vehicleYear);
	ResponseBean executeSaveVehicleYear(RequestBean request);
	ResponseBean executeUpdateVehicleYearByYear(RequestBean request);
	ResponseBean removeVehicleYearByYear(Integer vehicleYear);
	
}
