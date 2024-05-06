package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IVehicleModelService {
	
	ResponseBean searchVehicleModelByModel(String vehicleModel);
	
	ResponseBean executeSaveVehicleModel(RequestBean request);
	
	ResponseBean executeUpdateVehicleModelByModel(RequestBean request);
	
	ResponseBean removeVehicleModelByModel(String vehicleModel);

}
