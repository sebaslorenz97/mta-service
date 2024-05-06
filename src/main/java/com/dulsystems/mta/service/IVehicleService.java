package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IVehicleService {
	
	ResponseBean searchVehicleByPlate(String plate);
	
	ResponseBean executeSaveVehicle(RequestBean request);
	
	ResponseBean executeUpdateVehicleByPlate(RequestBean request);
	
	ResponseBean removeVehicleByPlate(String plate);

}
