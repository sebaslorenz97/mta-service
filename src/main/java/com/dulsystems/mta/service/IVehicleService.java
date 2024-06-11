package com.dulsystems.mta.service;

import java.util.List;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleBean;

public interface IVehicleService {
	
	ResponseBean searchVehicleByPlate(String plate);
	
	ResponseBean searchCustomerVehiclesByCustomerName(String customerName);
	
	ResponseBean executeSaveVehicle(RequestBean request);
	
	ResponseBean executeUpdateVehicleByPlate(RequestBean request);
	
	ResponseBean removeVehicleByPlate(String plate);

}
