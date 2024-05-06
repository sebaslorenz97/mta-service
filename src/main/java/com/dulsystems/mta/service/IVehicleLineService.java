package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IVehicleLineService {
	
	ResponseBean searchVehicleLineByLine(String vehicleLine);
	
	ResponseBean executeSaveVehicleLine(RequestBean request);
	
	ResponseBean executeUpdateVehicleLineByLine(RequestBean request);
	
	ResponseBean removeVehicleLineByLine(String vehicleLine);

}
