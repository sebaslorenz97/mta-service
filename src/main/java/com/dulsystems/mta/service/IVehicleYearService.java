package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IVehicleYearService {

	ResponseBean searchVehicleYearByYear(Integer vehicleYear);
	
	ResponseBean executeSaveVehicleYear(RequestBean request);
	
	ResponseBean executeUpdateVehicleYearByYear(RequestBean request);
	
	ResponseBean removeVehicleYearByYear(Integer vehicleYear);
	
}
