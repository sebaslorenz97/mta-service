package com.dulsystems.mta.dao;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleLineBean;

public interface IVehicleLineDao {
	
	VehicleLineBean searchVehicleLineByLine(String vehicleLine);
	
	boolean executeSaveVehicleLine(RequestBean request);
	
	boolean executeUpdateVehicleLineByLine(RequestBean request);
	
	boolean removeVehicleLineByLine(String vehicleLine);

}
